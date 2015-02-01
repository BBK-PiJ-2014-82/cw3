package cw3;

import static cw3.ErrorMessage.*;

/**
 * This is an implementation of FunctionalList that extends LinkedList.
 * 
 * @author James
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    
    /**
     * Class Constructor.
     */
    public void FunctionalLinkedList(){}
    
    @Override
    public ReturnObject head(){
        ReturnObject returnItem;
        if(isEmpty()){
            returnItem = new ReturnObjectImpl(EMPTY_STRUCTURE);
        } else {
            returnItem = new ReturnObjectImpl(get(0).getReturnValue());
        }
        return returnItem;
    }
    
    @Override
    public FunctionalList rest(){
        FunctionalList returnList = new FunctionalLinkedList();
        if(!this.isEmpty()){
            for(int i = 1; i < size; i++){
                Object addItem = get(i).getReturnValue();
                returnList.add(addItem);
            }
        }
        return returnList;
    }
    
}