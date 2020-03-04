package com.invillia.acme.helpers;

public class JsonReturn<T>{
	
	public Integer Code;
    public String Message;
    public T Data;
    public Exception ResultException;

	public void SetSuccess()
    {
		eCodeReturn t = eCodeReturn.SUCCESS;
        Code = t.getCode();
        Message = "Success";
    }
    
    public void SetSuccess(T obj)
    {
    	eCodeReturn t = eCodeReturn.SUCCESS;
        Code = t.getCode();
        Message = "Success";

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetInvalidParameter()
    {
        SetInvalidParameter(null);
    }
    
    public void SetInvalidParameter(T obj)
    {
    	eCodeReturn t = eCodeReturn.INVALID_PARAMETER;
        Code = t.getCode();
        Message = "Invalid parameter";

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetUndefinedError(T obj, String message)
    {
    	eCodeReturn t = eCodeReturn.UNDEFINED_ERROR;
        Code = t.getCode();
        Message = message;

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetActionNotPerformed(T obj)
    {
    	eCodeReturn t = eCodeReturn.ACTION_NOT_PERFORMED;
        Code = t.getCode();
        Message = "Action not performed";

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetActionNotPerformed()
    {
    	eCodeReturn t = eCodeReturn.ACTION_NOT_PERFORMED;
        Code = t.getCode();
        Message = "Action not performed";
    }
    
    public void SetErrorSearch(T obj)
    {
    	eCodeReturn t = eCodeReturn.SEARCH_ERROR;
        Code = t.getCode();
        Message = "Error fetching entity";

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetNotFound(T obj)
    {
    	eCodeReturn t = eCodeReturn.NOTFOUND;
        Code = t.getCode();
        Message = "Entity not found";

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetParmeterNotNull(T obj)
    {
    	eCodeReturn t = eCodeReturn.PARAMETER_CAN_NOT_NULL;
        Code = t.getCode();
        Message = "Parameter submitted can not be null";

        if (obj != null)
        {
            Data = (T)obj;
        }
    }
    
    public void SetException(Exception ex)
    {
        SetException(ex, null);
    }
    
    public void SetException(Exception ex, T obj)
    {
        SetException(ex, obj, false);
    }
    
    public void SetException(Exception ex, T obj, boolean IsShowExceptionDetails)
    {
        eCodeReturn t = eCodeReturn.EXCEPTION;
        Code = t.getCode();
        Message = "An exception occurred. Please check the application log";

        if (obj != null)
        {
            Data = (T)obj;
        }

        if (!IsShowExceptionDetails)
        {
            ResultException = new Exception(ex.getMessage());
        }
        else ResultException = ex;
    }
}
