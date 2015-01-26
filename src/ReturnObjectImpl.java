/**
 * This is an implementation of the ReturnObject interface.
 * 
 * @author James
 */
public class ReturnObjectImpl implements ReturnObject {
    
    /**
     * The wrapper for the object that will be entered into a list.
     */
    private Object toReturn;
    
    /**
     * The error message that will be returned via this Return Object.
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
        return !(error == null);
    }
    
    @Override
    public ErrorMessage getError(){
        if(hasError()){
            return error;
        } else {
            return ErrorMessage.NO_ERROR;
        }
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