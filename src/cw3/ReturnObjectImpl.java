package cw3;

/**
 * This is an implementation of the ReturnObject interface.
 * 
 * @author James
 */
public class ReturnObjectImpl implements ReturnObject {
    
    /**
     * The object that is wrapped by this ReturnObject.
     */
    private Object toReturn;
    
    /**
     * The error message that will be returned via this ReturnObject.
     */
    private ErrorMessage error;
    
    /**
     * Class Constructor for empty Return Object.
     */
    public ReturnObjectImpl(){}
    
    /**
     * Class Constructor with object to wrap inside Return Object.
     * 
     * @param item The Object to be wrapped.
     */
    public ReturnObjectImpl(Object item){
        toReturn = item;
        error = ErrorMessage.NO_ERROR;
    }
    
    /**
     * Class Constructor with error message to wrap inside Return Object.
     * 
     * @param error The ErrorMessage to be wrapped.
     */
    public ReturnObjectImpl(ErrorMessage error){
        this.error = error;
    }
    
    @Override
    public boolean hasError(){
        return !(error == ErrorMessage.NO_ERROR);
    }
    
    @Override
    public ErrorMessage getError(){
        return error;
    }
    
    @Override
    public Object getReturnValue(){
        if(hasError()){
            return null;
        } else {
            return toReturn;
        }
    }
}