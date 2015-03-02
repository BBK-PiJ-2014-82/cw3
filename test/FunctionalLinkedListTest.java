import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FunctionalLinkedListTest {
    
    FunctionalList myArray;
    
    @Before
    public void createList(){
        myArray = new FunctionalLinkedList();
    }
    
    @Test
    public void testHead(){
        // Check attempt to return head from empty array.
        ReturnObject returnMsg = myArray.head();
        assertEquals("Head return value is not empty.", ErrorMessage.EMPTY_STRUCTURE, returnMsg.getError());
        
        // Add 100 objects to an array.
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        
        // Check that the value of head is correct.
        int headInt = (Integer) myArray.head().getReturnValue();
        assertEquals("Head return value is incorrect.", 10, headInt);
        
        // Check that the original array is unmodified.
        for(int i = 0; i < 100; i++){
            int j = (Integer) myArray.get(i).getReturnValue();
            assertEquals("Original array has been modified.", (i + 1) * 10, j);
        }
    }
    
    @Test
    public void testRest(){
        FunctionalList restList;
        
        // Check 'rest' applied to empty list returns empty list.
        restList = myArray.rest();
        boolean empty = restList.isEmpty();
        assertTrue("The returned list is not empty.", empty);
        
        // Add 100 objects to the array.
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        
        // Check that the correct array is returned.
        restList = myArray.rest();
        assertEquals("Rest returned size is incorrect", 99, restList.size());
        for(int i = 0; i < 99; i++){
            int result = (Integer) restList.get(i).getReturnValue();
            assertEquals("Rest return value is incorrect.", (i + 2) * 10, result);
        }
        
        // Check that original array hasn't been modified.
        for(int i = 0; i < 100; i++){
            int j = (Integer) myArray.get(i).getReturnValue();
            assertEquals("Original array has been modified.", (i + 1) * 10, j);
        }
    }
    
}