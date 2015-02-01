import cw3.ReturnObject;
import cw3.FunctionalLinkedList;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static cw3.ErrorMessage.*;
import cw3.FunctionalList;

public class FunctionalLinkedListTest {
    
    FunctionalList myArray;
    
    @Before
    public void createList(){
        myArray = new FunctionalLinkedList();
    }
    
    @Test
    public void testHead(){
        // Add 100 objects to an array.
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        
        // Check that the value of head is correct.
        int headInt = (Integer) myArray.head().getReturnValue();
        assertEquals("Head return value is incorrect.", 10, headInt);
        for(int i = 0; i < 100; i++){
            int j = (Integer) myArray.get(i).getReturnValue();
            assertEquals("Original array has been modified.", (i + 1) * 10, j);
        }
    }
    
    @Test
    public void testHeadIsEmpty(){
        ReturnObject returnMsg = myArray.head();
        assertEquals("Head return value is not empty.", EMPTY_STRUCTURE, returnMsg.getError());
    }
    
    @Test
    public void testRest(){
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        FunctionalLinkedList restList = myArray.rest();
        for(int i = 0; i < 99; i++){
            int result = (Integer) restList.get(i).getReturnValue();
            assertEquals("Rest return value is incorrect.", (i + 2) * 10, result);
        }
        for(int i = 0; i < 100; i++){
            int j = (Integer) myArray.get(i).getReturnValue();
            assertEquals("Original array has been modified.", (i + 1) * 10, j);
        }
    }
    
    @Test
    public void testRestReturnsEmpty(){
        boolean isEmpty = myArray.isEmpty();
        assertTrue("The newly created array is not empty.", isEmpty);
    }
    
}