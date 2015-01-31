import cw3.ReturnObject;
import cw3.FunctionalArrayList;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static cw3.ErrorMessage.*;
import cw3.FunctionalList;

public class FunctionalArrayListTest {
    
    FunctionalList myArray;
    
    @Before
    public void createList(){
        myArray = new FunctionalArrayList();
    }
    
    @Test
    public void testHead(){
        // Check attempt to return head from empty array.
        ReturnObject returnMsg = myArray.head();
        assertEquals("Head return value is not empty.", EMPTY_STRUCTURE, returnMsg.getError());
        
        // Add 100 objects.
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        
        // Check that the head is returned correctly.
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
        
        // Add 100 objects into the list.
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        
        // Test rest function works correctly
        restList = myArray.rest();
        for(int i = 0; i < 99; i++){
            int result = (Integer) restList.get(i).getReturnValue();
            assertEquals("Rest return value is incorrect.", (i + 2) * 10, result);
        }
        
        // Check that original array has not been modified.
        for(int i = 0; i < 100; i++){
            int j = (Integer) myArray.get(i).getReturnValue();
            assertEquals("Original array has been modified.", (i + 1) * 10, j);
        }
    }
    
    @Test
    public void testReturnsEmpty(){
        boolean isEmpty = myArray.isEmpty();
        assertTrue("The newly created array is not empty.", isEmpty);
    }
    
}