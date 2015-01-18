public class SampleableListImpl extends ArrayList {
    
    List sampleList;
    
    public SampleableListImpl(ArrayList list){
        sampleList = list;
    }
    
    public SampleableListImpl(LinkedList list){
        sampleList = list;
    }
    
    public SampleableList sample(){
        SampleableList returnList = (SampleableList) sampleList; 
        for(int i = 0; i < sampleList.size(); i++){
            if(i%2 == 1){
                sampleList.add(returnList.get(i).getReturnValue());
            }
        }
        return returnList;
    }
    
}