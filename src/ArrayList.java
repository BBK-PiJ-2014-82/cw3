/**
 * This is an implementation of the List interface using arrays.  The array
 * is an array of objects that is initially set at size 10 but can resize
 * later in order to accommodate larger arrays while using only the memory
 * necessary.
 * 
 * @author James
 */
public class ArrayList implements List {
    
    /**
     * The size of the array used to keep track of when the array is full
     * and needs to be resized.
     */
    protected int arraySize = 10;
    
    /**
     * The array which holds the list of objects.
     */
    protected Object[] newList = new Object[arraySize];
    
    /**
     * The number of items in the array and also the first null position in the 
     * array at which a new object can be entered.
     */
    private int nextFree = 0;
    
    /**
     * Class Constructor creates 100 place array.
     */
    public void ArrayList(){}
    
    @Override
    public boolean isEmpty(){return nextFree == 0;}
    
    @Override
    public int size(){return nextFree;}
    
    @Override
    public ReturnObject get(int index){
        ReturnObject returnItem;
        returnItem = checkIndex(index);
        // Test whether the index is within range.
        if(returnItem.hasError()){
            return returnItem;
        } else {
            returnItem = new ReturnObjectImpl(newList[index]);
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject remove(int index){
        ReturnObject returnItem;
        returnItem = checkIndex(index);
        // Test whether the index is within range.
        if(returnItem.hasError()){
            return returnItem;
        } else {
            returnItem = new ReturnObjectImpl(newList[index]);
            // Repace the removed object with next object & move all others down.
            for(int i = index; i < nextFree-1; i++){
                newList[i] = newList[i+1];
            }
            // Resize the list.
            newList[nextFree-1] = null;
            nextFree -= 1;
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject add(int index, Object item){
        ReturnObject returnItem;
        // Test the index is within range.
        returnItem = checkIndex(index);
        if(returnItem.hasError()){
            return returnItem;
        }
        // Test the item is not null.
        returnItem = checkNull(item);
        if(returnItem.hasError()){
            return returnItem;
        } else {
            if(nextFree+1 > arraySize){increaseSize();}
            for(int i = nextFree; i > index; i--){
                newList[i] = newList[i-1];
            }
            nextFree += 1;
            returnItem = new ReturnObjectImpl(newList[index]);
            newList[index] = item;
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject add(Object item){
        ReturnObject returnItem;
        returnItem = checkNull(item);
        if(returnItem.hasError()){
            return returnItem;
        } else {
            if(nextFree+1 > arraySize){increaseSize();}
            newList[nextFree] = item;
            nextFree += 1;
            returnItem = new ReturnObjectImpl();
            return returnItem;
        }
    }
    
    /**
     * Copies the existing array into an array twice the size.
     */
    private void increaseSize(){
        Object[] temp = new Object[arraySize * 2];
        System.arraycopy(newList, 0, temp, 0, arraySize );
        newList = temp;
        arraySize = arraySize * 2;
    }
    
    /**
     * Checks the index is within a valid range.
     * 
     * @param index the index to be tested.
     * @return a wrapper containing the error message that needs to be returned.
     */
    private ReturnObject checkIndex(int index){
        ReturnObjectImpl error;
        if(index < 0 || index >= nextFree){    
            // Test whether the list is empty.
            if(nextFree != 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
        } else {
            error = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
        return error;
    }
    
    /**
     * Tests whether the Object provided is null.
     * 
     * @param item the object to be tested.
     * @return a wrapper containing the error message that needs to be returned.
     */
    private ReturnObject checkNull(Object item){
        ReturnObjectImpl error;
        if(item == null){
            error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            error = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
        return error;
    }
    
}