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
    public void testIsEmpty(){
        boolean result = myArray.isEmpty();
        assertTrue("New List is not empty after construction.", result);
    }
    
    @Test
    public void testAddObject(){
        Integer i = 100;
        myArray.add(i);
        boolean result = myArray.isEmpty();
        assertFalse("New List is empty after add().", result);
    }
    
    @Test
    public void testGet(){
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        Integer result = (Integer) myArray.get(10).getReturnValue();
        assertEquals("Incorrect value returned.", (Integer)10, result);
    }
    
    @Test
    public void testSize(){
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        int result = myArray.size();
        assertEquals("The size of the List is incorrect.", 20, result);
    }
    
    @Test
    public void testRemove(){
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        myArray.remove(10);
        int value = (Integer) myArray.get(10).getReturnValue();
        int size = myArray.size();
        assertEquals("The value returned is incorrect.", 11, value);
        assertEquals("The size of the List is incorrect.", 19, size);
    }
    
    @Test
    public void testRemoveUntilDeleted(){
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        for(int i = 20; i > 0; i--){
            myArray.remove(0);
        }
        boolean result = myArray.isEmpty();
        assertTrue("The List is not empty.", result);
    }
    
    @Test
    public void testAddMoreThanArraySize(){
        for(int i = 0; i < 250; i++){
            myArray.add(i);
        }
        int result = myArray.size();
        assertEquals("List size is incorrect.", 250, result);
    }
    
    @Test
    public void testAddingWithIndex(){
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        myArray.add(10, 3000);
        int size = myArray.size();
        int value = (Integer) myArray.get(10).getReturnValue();
        assertEquals("List size is incorrect.", 21, size);
        assertEquals("Returned value is incorrect.", 3000, value);
    }
    
    @Test
    public void testAddString(){
        String str = "Test";
        myArray.add(str);
        String result = (String) myArray.get(0).getReturnValue();
        assertEquals("The incorrect String is returned.", "Test", result);
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