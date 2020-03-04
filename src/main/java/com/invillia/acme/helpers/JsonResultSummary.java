package com.invillia.acme.helpers;

import javax.servlet.http.HttpServletResponse;

public class JsonResultSummary {
	public JsonResultSummary() {
	}

	public int Code;
	public String Message;
	public Object Data;
	public Throwable ResultException;

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

	public Throwable getResultException() {
		return ResultException;
	}

	public void setResultException(Throwable resultException) {
		ResultException = new Throwable(resultException.getMessage());
	}

	public JsonResultSummary(Object dataList) {
		Code = HttpServletResponse.SC_OK;
		Message = "Success";

		if (dataList != null) {
			Data = dataList;
		}
	}

	public JsonResultSummary(Exception ex) {
		SetException(ex);
	}

	private void SetException(Exception ex) {
		Code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		Message = String.format("Ops: %s - %s", "An exception occurred", "Please check the application log");

		ResultException = new Exception(ex.getMessage());
	}

	public void SetNotFound() {
		Code = HttpServletResponse.SC_NOT_FOUND;
		Message = "Entity not found";
	}
}
