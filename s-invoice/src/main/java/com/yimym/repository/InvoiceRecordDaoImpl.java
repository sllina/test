package com.yimym.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.yimym.dto.InvoiceRecordDto;
import com.yimym.model.InvoiceRecordPagableResult;
import com.yimym.model.QueryModel;
import com.yimym.model.QuerySortModel;
import com.yimym.model.SortModel;
import com.yimym.util.SerialTool;

@Component
public class InvoiceRecordDaoImpl {
	@PersistenceContext
	private EntityManager em;
	
	SerialTool st = new SerialTool();
	String sql1 = "select * from invoice_record where status = 0 ";
	String sql = "from invoice_record where status = 0 ";
	String sql2 = "";
	
	@SuppressWarnings("unchecked")
	public InvoiceRecordPagableResult getInvoiceRecordResult(Integer page,Integer pageSize,QuerySortModel qust){
		if(qust.getQuerys()!=null){
			List<?> querys = qust.getQuerys();
			for(Object query: querys){
				if(query.getClass().getSimpleName().equals("ArrayList")) {
					JudgeChild(query);
				}else{
					if(query.toString().length()>2){
						subSql(query);
					}
				}
			}
		}
		
		String sql3 = " order by ";
		
		SortModel sort = qust.getSort();
		if(sort!=null){
			String name = new SerialTool().humpToLine2(sort.getName());
			if(name.contains("price") || name.equals("turn_over")){
				sql3 += "convert("+name+",decimal) "+sort.getSort();	
			}else{
				sql3 += ""+name+" "+sort.getSort();
			}
		}else{
			sql3 += "created_at desc";
		}
		
		
		Query query1 = em.createNativeQuery("select count(*) " + sql +sql2);
		String o = query1.getSingleResult().toString();
		Long totalElements = Long.parseLong(o);
		
		
		Query query = em.createNativeQuery(sql1+sql2+sql3+" limit "+ (page - 1) * pageSize + "," +  pageSize,InvoiceRecordDto.class);
		List<InvoiceRecordDto> li = query.getResultList();
		
		sql2 = "";
		
		InvoiceRecordPagableResult record = new InvoiceRecordPagableResult();
		
		long totalPages = (long) Math.ceil((totalElements + 0.0) / pageSize);
		record.setTotalPages(totalPages);
		record.setTotalElements(totalElements);
		record.setInvoiceRecordList(li);
		
		return record;
	}
	
	//自定义查询，递归判断
		@SuppressWarnings("rawtypes")
		public void JudgeChild(Object query){
			if(query.getClass().getSimpleName().equals("ArrayList")) {
				List<?> qq = (List<?>) query;
				for(int i = 0;i<qq.size();i++){
					Object qx = (Object)qq.get(i);
					if(qx.getClass().getSimpleName().equals("ArrayList")) {
						JudgeChild(qx);
						sql2 = sql2+ ")";
					}else{
						if(qx.toString().length()>2){
							String s = SerialTool.hashMapToJson((HashMap)qx);
							JSONObject jobj = new JSONObject(s);
							QueryModel q = new QueryModel();
							q.setColumn(jobj.getString("column"));
							q.setJoin(jobj.getString("join"));
							q.setQuery(jobj.getString("query"));
							q.setValue(jobj.getString("value"));
						
							sql2 = sql2 +" "+q.getJoin()+" ";
							
							if(i==0){
								sql2 = sql2+ "(";
							}
							
							String name = st.humpToLine2(q.getColumn());
							
							getQueryValue(name,q);
							
							if(i==qq.size()-1){
								sql2 = sql2+ ")";
							}
						}
					}
				}
			}
		}
		
		//首层的解析
		@SuppressWarnings("rawtypes")
		public void subSql(Object query){
			String s = SerialTool.hashMapToJson((HashMap)query);
			JSONObject jobj = new JSONObject(s);
			QueryModel q = new QueryModel();
			q.setColumn(jobj.getString("column"));
			q.setJoin(jobj.getString("join"));
			q.setQuery(jobj.getString("query"));
			q.setValue(jobj.getString("value"));
			
			String name = st.humpToLine2(q.getColumn());
			
			sql2 = sql2 +" "+q.getJoin()+" ";
			
			getQueryValue(name,q);
			
		}
		
		
		//取值
		public void getQueryValue(String name,QueryModel q){
									
			sql2 = sql2 + name+" ";
			if(q.getQuery().equals("like") || q.getQuery().equals("in") || name.contains("price") || name.contains("num") || q.getQuery().equals("not in")){
				if(q.getQuery().equals("like")){
					sql2 = sql2 + q.getQuery() +" '%"+q.getValue() +"%'";
				}
				else if(q.getQuery().equals("in") || q.getQuery().equals("not in")){
					String v1 = q.getValue();
					
					String[] v2 = v1.split(",");
					String v3 = "";
					for(int i=0;i<v2.length;i++){
						 v3 += "'"+v2[i]+"'"+",";	
					}
					sql2 = sql2 + q.getQuery() +"("+v3.substring(0,v3.length()-1)+")";
				}
				else{
					sql2 = sql2 + q.getQuery() +q.getValue();
				}
			}
			else{
				sql2 = sql2 + q.getQuery() + "'"+q.getValue()+"'";
			}
		}
		
}
