package cw3;

/**
 * This is an implementation of SampleableList that extends FunctionalArrayList.  The
 * sampleable list can take another list as a constructor and transform that
 * list into a sampleable list.
 * 
 * @author James
 */
public class SampleableListImpl extends ArrayList implements SampleableList  {
    
    /**
     * Class Constructor.
     */
    public SampleableListImpl(){}
    
    /**
     * Class Constructor for ArrayList.
     * 
     * @param list Another that can be sampled.
     */
    public SampleableListImpl(List list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    @Override
    public SampleableList sample(){
        SampleableList returnList = new SampleableListImpl(); 
        for(int i = 0; i < size(); i++){
            if(i%2 == 0){returnList.add(get(i).getReturnValue());}
        }
        return returnList;
    }
    
}