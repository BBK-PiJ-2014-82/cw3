package cw3;

/**
 * This is an implementation of FunctionalList that extends ArrayList
 * 
 * @author James
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
    
    /**
     * Class Constructor.
     */
    public void FunctionalArrayList(){}
    
    @Override
    public ReturnObject head(){
        if(isEmpty()){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return error;
        } else {
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[0]);
            return returnItem;
        }
    }
    
    @Override
    public FunctionalArrayList rest(){
        if(isEmpty()){
            FunctionalArrayList empty = new FunctionalArrayList();
            return empty;
        } else {
            FunctionalArrayList returnList = new FunctionalArrayList();
            for(int i = 1; i < arraySize; i++){
                Object addItem = get(i).getReturnValue();
                returnList.add(addItem);
            }
            return returnList;
        }
    }
    
}