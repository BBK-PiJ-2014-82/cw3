public class ReturnObjectImpl implements ReturnObject {
    
    private Object toReturn;
    private ErrorMessage error = NO_ERROR;
    
    public ReturnObjectImpl(Object item){
        toReturn = item;
    }
    
    public boolean hasError(){
        if(error != NO_ERROR){
            return false;
        } else {
            return true;
        }
    }
    
    public ErrorMessage getError(){
        return error;
    }
    
    public Object getReturnValue(){
        if(hasError()){
            return null;
        } else {
            return toReturn;
        }
    }
    
}