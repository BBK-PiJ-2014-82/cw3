import cw3.SampleableListImpl;
import cw3.FunctionalLinkedList;
import cw3.LinkedList;
import cw3.ArrayList;
import cw3.FunctionalArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SampleableListTest {
    
    @Test
    public void SampleArrayListTest(){
        ArrayList myList = new ArrayList();
        for(int i = 1; i < 201; i++){
            myList.add(i * 10);
        }
        SampleableListImpl newList = new SampleableListImpl(myList);
        for(int i = 0; i < myList.size(); i++){
            int j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", (i+1) * 10, j);
        }
    }
    
    @Test
    public void SampleLinkedListTest(){
        LinkedList myList = new LinkedList();
        for(int i = 1; i < 201; i++){
            myList.add(i * 10);
        }
        SampleableListImpl newList = new SampleableListImpl(myList);
        for(int i = 0; i < myList.size(); i++){
            int j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", (i+1) * 10, j);
        }
    }
    
    @Test
    public void SampleFunctionalArrayListTest(){
        FunctionalArrayList myList = new FunctionalArrayList();
        for(int i = 1; i < 201; i++){
            myList.add(i * 10);
        }
        SampleableListImpl newList = new SampleableListImpl(myList);
        for(int i = 0; i < myList.size(); i++){
            int j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", (i+1) * 10, j);
        }
    }
    
    @Test
    public void SampleFunctionalLinkedListTest(){
        FunctionalLinkedList myList = new FunctionalLinkedList();
        for(int i = 1; i < 201; i++){
            myList.add(i * 10);
        }
        SampleableListImpl newList = new SampleableListImpl(myList);
        for(int i = 0; i < myList.size(); i++){
            int j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", (i+1) * 10, j);
        }
    }
    
}