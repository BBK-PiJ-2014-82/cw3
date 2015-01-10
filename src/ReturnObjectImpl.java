public class ReturnObjectImpl implements ReturnObject {
    
    private ErrorMessage error;
    
    public ReturnObjectImpl(){}
    
    public ReturnObjectImpl(ErrorMessage error){
        this.error = error;
    }
    
    public boolean hasError(){
        if(error == null){
            return false;
        } else {
            return true;
        }
    }
    
    public ErrorMessage getError(){
        if(hasError()){
            return error;
        } else {
            return ErrorMessage.NO_ERROR;
        }
    }
    
    public Object getReturnValue(){
        if(hasError()){
            return null;
        } else {
            return toReturn;
        }
    }
}