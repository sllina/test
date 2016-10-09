package com.yimym.configuration;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yimym.model.ErrorInfo;
/**
 * 异常处理器。该类会处理所有在执行标有@RequestMapping注解的方法时发生的异常
 * Created by whf on 4/7/16.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	ErrorInfo er = new ErrorInfo();
	 /**
     * 处理@RequestParam错误, 即参数不足
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<Object>(er.getMissParam(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理500错误
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        // 请求方式不支持
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return new ResponseEntity<Object>(er.getRequestMethodNotSupported(), HttpStatus.BAD_REQUEST);
        }    
        return new ResponseEntity<Object>(er.getNotKnownError(), HttpStatus.BAD_REQUEST);
    }


    /**
     * 处理参数类型转换失败
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(er.getTypeMismatch(), HttpStatus.BAD_REQUEST);
    }
}
