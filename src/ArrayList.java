public class ArrayList implements List {
    
    protected int arraySize = 100;
    protected Object[] newList = new Object[arraySize];
    private int nextFree = 0;
    
    public void ArrayList(){}
    
    @Override
    public boolean isEmpty(){return nextFree == 0;}
    
    @Override
    public int size(){
        if(isEmpty()){return 0;} else {return nextFree;}
    }
    
    @Override
    public ReturnObject get(int index){
        if(index < 0 || index >= nextFree){
            ReturnObjectImpl error;
            if(nextFree != 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
            return error;
        } else {
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[index]);
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject remove(int index){
        if(index < 0 || index >= nextFree){
            ReturnObjectImpl error;
            if(nextFree != 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
            return error;
        } else {
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[index]);
            for(int i = index; i < nextFree-1; i++){
                newList[i] = newList[i+1];
            }
            newList[nextFree-1] = null;
            nextFree -= 1;
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject add(int index, Object item){
        if(index < 0 || index > nextFree){
            ReturnObjectImpl error;
            if(nextFree != 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
            return error;
        } else {
            if(nextFree+1 > arraySize){increaseSize();}
            for(int i = nextFree; i > index; i--){
                newList[i] = newList[i-1];
            }
            nextFree += 1;
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[index]);
            newList[index] = item;
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject add(Object item){
        if(item == null){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return error;
        } else {
            if(nextFree+1 > arraySize){increaseSize();}
            newList[nextFree] = item;
            nextFree += 1;
            ReturnObjectImpl empty = new ReturnObjectImpl();
            return empty;
        }
    }
    
    private void increaseSize(){
        Object[] temp = new Object[arraySize * 2];
        System.arraycopy(newList, 0, temp, 0, arraySize );
        newList = temp;
        arraySize = arraySize * 2;
    }
}