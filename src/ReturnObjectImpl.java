public class ReturnObjectImpl implements ReturnObject {
    
    Object toReturn;
    
    public ReturnObjectImpl(Object item){
        toReturn = item;
    }
    
    public boolean hasError(){
        
    }
    
    public ErrorMessage getError(){
        if(hasError()){
            
        } else {
            
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