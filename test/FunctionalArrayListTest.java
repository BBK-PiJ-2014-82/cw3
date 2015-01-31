import cw3.ReturnObject;
import cw3.ErrorMessage;
import cw3.FunctionalArrayList;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FunctionalArrayListTest {
    
    FunctionalArrayList myArray;
    
    @Before
    public void createList(){
        myArray = new FunctionalArrayList();
    }
    
    @Test
    public void testHead(){
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
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
        assertEquals("Head return value is not empty.", ErrorMessage.EMPTY_STRUCTURE, returnMsg.getError());
    }
    
    @Test
    public void testRest(){
        for(int i = 0; i < 100; i++){
            myArray.add((i + 1) * 10);
        }
        FunctionalArrayList restList = myArray.rest();
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