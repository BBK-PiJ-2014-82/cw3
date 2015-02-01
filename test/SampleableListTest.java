import cw3.SampleableListImpl;
import cw3.FunctionalLinkedList;
import cw3.LinkedList;
import cw3.ArrayList;
import cw3.FunctionalArrayList;
import cw3.SampleableList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SampleableListTest {
    
    @Test
    public void SampleArrayListTest(){
        // Create initial list to be sampled.
        ArrayList myList = new ArrayList();
        for(int i = 1; i < 201; i++){myList.add(i * 10);}
        
        // Create sample of the initial list.
        SampleableList newList;
        newList = new SampleableListImpl(myList);
        newList = newList.sample();
        
        // Test the size of the sampled list.
        boolean sizeCheck = newList.size() == myList.size() / 2;
        assertTrue("The new list is not a true sample.", sizeCheck);
        
        // Check that the correct numbers are returned.
        int j = 0;
        for(int i = 0; i < newList.size(); i++){
            j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", ((i*2)+1) * 10, j);
        }
    }
    
    @Test
    public void SampleLinkedListTest(){
        // Create initial list to be sampled.
        LinkedList myList = new LinkedList();
        for(int i = 1; i < 201; i++){
            myList.add(i * 10);
        }
        
        // Create sample of the initial list.
        SampleableList newList;
        newList = new SampleableListImpl(myList);
        newList = newList.sample();
        
        // Test the size of the sampled list.
        boolean sizeCheck = newList.size() == myList.size() / 2;
        assertTrue("The new list is not a true sample.", sizeCheck);
        
        // Check that the correct numbers are returned.
        int j = 0;
        for(int i = 0; i < newList.size(); i++){
            j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", ((i*2)+1) * 10, j);
        }
    }
    
    @Test
    public void SampleFunctionalArrayListTest(){
        // Create initial list to be sampled.
        FunctionalArrayList myList = new FunctionalArrayList();
        for(int i = 1; i < 201; i++){
            myList.add(i * 10);
        }
        
        // Create sample of the initial list.
        SampleableList newList;
        newList = new SampleableListImpl(myList);
        newList = newList.sample();
        
        // Test the size of the sampled list.
        boolean sizeCheck = newList.size() == myList.size() / 2;
        assertTrue("The new list is not a true sample.", sizeCheck);
        
        // Check that the correct numbers are returned.
        int j = 0;
        for(int i = 0; i < newList.size(); i++){
            j = (Integer) newList.get(i).getReturnValue();
            assertEquals("Sampled numbers are incorrect.", ((i*2)+1) * 10, j);
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