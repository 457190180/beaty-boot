package com.yimew.utils;

import com.yimew.web.Const;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ErrorUtils {
	
	private ErrorUtils(){
		
	}

	public static final String getErrorInfo(Errors errors) {
		StringBuffer sb = new StringBuffer();
		sb.append("errorNum:"+errors.getErrorCount()+ Const.SPLIT_CODE);
		StringBuffer defaultMessage =null;
		List<ObjectError> allErrors = errors.getAllErrors();
		for (ObjectError objectError : allErrors) {
			defaultMessage =new StringBuffer(objectError.getDefaultMessage()+ Const.SPLIT_CODE);
			sb.append(defaultMessage);
		}
		return sb.toString();
	}
	

}
