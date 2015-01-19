public class SampleableListImpl extends ArrayList implements SampleableList  {
    
    public SampleableListImpl(){}
    
    public SampleableListImpl(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    public SampleableListImpl(LinkedList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    public SampleableListImpl(FunctionalArrayList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    public SampleableListImpl(FunctionalLinkedList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    @Override
    public SampleableList sample(){
        SampleableListImpl returnList = new SampleableListImpl(); 
        for(int i = 0; i < size(); i++){
            if(i%2 == 1){returnList.add(get(i).getReturnValue());}
        }
        return returnList;
    }
    
}