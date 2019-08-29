package com.benqio.push.portal.exception;


import com.benqio.push.framework.ErrorCode;
import com.benqio.push.framework.Message;
import com.benqio.push.framework.beans.Result;
import com.benqio.push.framework.beans.ResultData;
import com.benqio.push.framework.exception.BussinessException;
import com.benqio.push.framework.util.BindingResultUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.http.conn.HttpHostConnectException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.net.NoRouteToHostException;
import java.util.List;

@Log4j2
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage());
        ex.printStackTrace();
        return handleExceptionInternal(ex, errors(ex.getBindingResult()), headers, status, request);
    }
    
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<MediaType> mediaTypes = ex.getSupportedMediaTypes();
        if (!CollectionUtils.isEmpty(mediaTypes)) {
            headers.setAccept(mediaTypes);
        }
        log.error(ex.getMessage());
        ex.printStackTrace();
        return handleExceptionInternal(ex, ex.getMessage(), headers, status, request);
    }
    
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
                                                         WebRequest request) {
        log.error(ex.getMessage());
        ex.printStackTrace();
        return handleExceptionInternal(ex, errors(ex.getBindingResult()), headers, status, request);
    }
    
    // @ResponseBody
    // @ExceptionHandler(value = { CommunicationsException.class })
    // protected ResponseEntity<Object> handleCommunications(CommunicationsException e, WebRequest request) {
    // // Result body = new Result(ErrorCode.ERROR, Messages.WARN_DB_CONNECTION_TIMED_OUT);
    // return handleExceptionInternal(e, errors(e), new HttpHeaders(), HttpStatus.OK, request);
    // }
    
    @ResponseBody
    @ExceptionHandler(value = { MyBatisSystemException.class })
    protected ResponseEntity<Object> handleMyBatisSystem(MyBatisSystemException e, WebRequest request) {
        log.error(e.getMessage());
        e.printStackTrace();
        Result body = new Result(ErrorCode.ERROR, Message.WARN_DBSERVER_ERROR);
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.OK, request);
    }
    
    // @ResponseBody
    // @ExceptionHandler(value = { ConnectException.class })
    // protected ResponseEntity<Object> handleConnect(ConnectException e, WebRequest request) {
    // Result body = new Result(ErrorCode.ERROR, Messages.WARN_CONNECTION_TIMED_OUT);
    // return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.OK, request);
    // }
    
    @ResponseBody
    @ExceptionHandler(value = { UnexpectedTypeException.class })
    protected ResponseEntity<Object> handleUnexpectedType(UnexpectedTypeException e, WebRequest request) {
        log.error(e.getMessage());
        Result body = new Result(ErrorCode.ERROR, Message.WARN_UNEXPECTED_TYPE);
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.OK, request);
    }
    
    @ResponseBody
    @ExceptionHandler(value = { RestClientException.class })
    protected ResponseEntity<Object> handleRestClient(RestClientException e, WebRequest request) {
        log.error(e.getMessage());
        e.printStackTrace();
        String message = "服务器处理异常！";
        if (e.getCause() instanceof HttpHostConnectException) {
            HttpHostConnectException ex = (HttpHostConnectException) e.getCause();
            message = ex.getHost().getHostName()+"服务器连接超时！";
        } else if (e.getCause() instanceof NoRouteToHostException) {
            message = "服务器网络异常！";
        }
        Result body = new Result(ErrorCode.ERROR, message);
        // Result body = new Result(ErrorCode.ERROR, Message.WARN_CONNECTION_TIMED_OUT);
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.OK, request);
    }
    
    @ResponseBody
    @ExceptionHandler(value = { DuplicateKeyException.class })
    protected ResponseEntity<Object> handleDuplicateKey(DuplicateKeyException e, WebRequest request) {
        log.error(e.getMessage());
        e.printStackTrace();
        Result body = new Result(ErrorCode.ERROR, Message.WARN_DUPLICATE_KEY_EXCEPTION);
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.OK, request);
    }
    
    @ResponseBody
    @ExceptionHandler(value = { BussinessException.class})
    protected ResponseEntity<Object> handleBussiness(BussinessException e, WebRequest request) {
        log.error(e.getMessage());
        e.printStackTrace();
        return handleExceptionInternal(e, errors(e), new HttpHeaders(), HttpStatus.OK, request);
    }
    
    @ResponseBody
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, RuntimeException.class,
            MultipartException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException e, WebRequest request) {
        log.error(e.getMessage());
        e.printStackTrace();
        return handleExceptionInternal(e, errors(e), new HttpHeaders(), HttpStatus.OK, request);
    }

//    @ResponseBody
//    @ExceptionHandler(value = {BadCredentialsException.class})
//    protected ResponseEntity<Object> handleConflict(BadCredentialsException e, WebRequest request) {
//        log.error(e.getMessage());
//        e.printStackTrace();
//        return handleExceptionInternal(e, errors(ErrorCode.USER_OR_PASSWORD_INVALID,"用户名或密码错误"), new HttpHeaders(), HttpStatus.OK, request);
//    }
    
    @ResponseBody
    @ExceptionHandler(value = { UncategorizedSQLException.class })
    protected ResponseEntity<Object> handleBatchUpdate(UncategorizedSQLException e, WebRequest request) {
        log.error(e.getMessage());
        e.printStackTrace();
        Result body = new Result(ErrorCode.ERROR, Message.WARN_DBSERVER_ERROR);
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.OK, request);
    }
    
    private Object errors(BindingResult result) {
        return new ResultData(ErrorCode.ERROR, Message.WARN_DATA_VALIDATE_FAIL, BindingResultUtil.errors(result));
    }
    
    private Object errors(RuntimeException e) {
        return new Result(ErrorCode.ERROR, e.getMessage());
    }

    private Object errors(int coce, String message) {
        return new Result(coce, message);
    }
}