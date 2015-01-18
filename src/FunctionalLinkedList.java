public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    
    public void FunctionalLinkedList(){}
    
    public ReturnObject head(){
        if(isEmpty()){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return error;
        } else {
            ReturnObjectImpl returnItem = new ReturnObjectImpl(get(0).getReturnValue());
            return returnItem;
        }
    }
    
    public FunctionalArrayList rest(){
        if(isEmpty()){
            FunctionalArrayList empty = new FunctionalArrayList();
            return empty;
        } else {
            FunctionalArrayList returnList = new FunctionalArrayList();
            for(int i = 1; i < size; i++){
                Object addItem = get(i).getReturnValue();
                returnList.add(addItem);
            }
            return returnList;
        }
    }
    
}