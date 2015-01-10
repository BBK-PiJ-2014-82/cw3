public class ArrayList implements List {
    
    private Object[] newList;
    private int length;
    private int lastUsed;
    
    public void ArrayList(int size){
        newList = new Object[size];
        length = size;
        lastUsed = 0;
    }
    
    public boolean isEmpty(){
        
    }
    
    public int size(){
        if(isEmpty()){
            return 0;
        } else {
            return lastUsed - 1;
        }
    }
    
    public ReturnObject get(int index){
        
    }
    
    public ReturnObject remove(int index){
        
    }
    
    public ReturnObject add(int index, Object item){
        
    }
    
    public ReturnObject add(Object item){
        if(item == null){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return error;
        } else {
            newList[lastUsed] = item;
            lastUsed =+ 1;
            ReturnObjectImpl empty = new ReturnObjectImpl();
            return empty;
        }
    }
}