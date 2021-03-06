/**
 * This is an implementation of FunctionalList that extends ArrayList.
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
        ReturnObject returnItem;
        if(isEmpty()){
            returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            returnItem = new ReturnObjectImpl(newList[0]);
        }
        return returnItem;
    }
    
    @Override
    public FunctionalList rest(){
        FunctionalList returnList = new FunctionalArrayList();
        if(!this.isEmpty()){
            // Copy all items apart from head into new list.
            for(int i = 1; i < arraySize; i++){
                Object addItem = get(i).getReturnValue();
                returnList.add(addItem);
            }
        }
        return returnList;
    }
    
}