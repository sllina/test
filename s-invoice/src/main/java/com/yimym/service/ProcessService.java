package com.yimym.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yimym.model.ProcessInfo;

@FeignClient(name = "process", url = "http://GATEWAY-SERVER:4000/process/")
public interface ProcessService {
	@RequestMapping(value = "/objprocs/{objid}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	List<ProcessInfo> getProcessDetail(@PathVariable("objid") String objid);
}