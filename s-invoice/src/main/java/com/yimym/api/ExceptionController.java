package com.yimym.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
@RestController
public class ExceptionController implements ErrorController {

	ErrorInfo er = new ErrorInfo();
	@Override
	public String getErrorPath() {
		return "/error";
	}

    @RequestMapping(value = "/error", produces =  { "application/json" })
    public Error error(HttpServletResponse resp, HttpServletRequest req) {
        // 错误处理逻辑
    	int status = getStatus(req);
    	if(status==500){
    		 return er.getNotKnownError();
    	}
        return er.getBadRequest();
    }

    /**
     * 获取错误编码
     * @param request
     * @return
     */
    private int getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
        	return 500;
        }     
        try {
        	return statusCode;
        }
        catch (Exception ex) {
        	return 500;
        }
    }
    
}
