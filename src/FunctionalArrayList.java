public class FunctionalArrayList extends ArrayList {
    
    public void FunctionalArrayList(){}
    
    public ReturnObject head(){
        ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[0]);
        return returnItem;
    }
    
    public FunctionalList rest(){
        
    }
    
}