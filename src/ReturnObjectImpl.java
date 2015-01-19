public class ReturnObjectImpl implements ReturnObject {
    
    private Object toReturn;
    private ErrorMessage error;
    
    public ReturnObjectImpl(){}
    
    public ReturnObjectImpl(Object item){
        toReturn = item;
    }
    
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