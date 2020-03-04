package com.invillia.acme.helpers;

public enum eCodeReturn {
	SUCCESS(200), 
	INVALID_PARAMETER(-1), 
	UNDEFINED_ERROR(-2), 
	ACTION_NOT_PERFORMED(-3), 
	SEARCH_ERROR(-4), 
	NOTFOUND(404),
	PARAMETER_CAN_NOT_NULL(-6),
	UNVERIFIED_ACCOUNT(-7), 
	INVALID_AUTHENTICATION(-8), 
	SESSION_EXPIRED(-9),
	INVALID_TOKEN(-10), 
	INVALID_MODEL(-11),

	UNAUTHORIZED(-401), 
	FORBIDDEN(-403), 
	NOTACCEPTABLE(-406),

	INVALID_APPICATIONKEY(-400),

	EXCEPTION(-99);

	private Integer code;
	 
	eCodeReturn(Integer code) {
        this.code = code;
    }
 
    public Integer getCode() {
        return code;
    }
}
