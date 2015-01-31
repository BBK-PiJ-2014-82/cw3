package cw3;

/**
 * This is an implementation of SampleableList that extends ArrayList.
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
     * @param list An ArrayList that will be sampled.
     */
    public SampleableListImpl(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    /**
     * Class Constructor for LinkedList.
     * 
     * @param list A LinkedList that will be sampled.
     */
    public SampleableListImpl(LinkedList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    /**
     * Class Constructor for FunctionalArrayList.
     * 
     * @param list A FunctionArrayList that will be sampled.
     */
    public SampleableListImpl(FunctionalArrayList list){
        for(int i = 0; i < list.size(); i++){
            add(list.get(i).getReturnValue());
        }
    }
    
    /** Class Constructor for FunctionalLinkedList.
     * 
     * @param list A FunctionalLinkedList that will be sampled.
     */
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