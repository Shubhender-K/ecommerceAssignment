package com.example.Assignment.ecommerceAssignment.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Assignment.ecommerceAssignment.payloads.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){	
		String message = ex.getMessage();
		ApiResponse apiresponse= new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidException(org.springframework.web.bind.MethodArgumentNotValidException ex){
		Map<String , String> hm=new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String field = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			hm.put(field, defaultMessage);
		});
		
		return new ResponseEntity<Map<String,String>>(hm,HttpStatus.BAD_REQUEST);
	}

}
