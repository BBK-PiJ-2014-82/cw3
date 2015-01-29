import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A series of tests to check that the class ArrayList works correctly.
 * 
 * @author James
 */
public class ArrayListTest {
    
    ArrayList myArray;
    
    @Before
    public void createList(){
        myArray = new ArrayList();
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
        // Test getting an object from empty array.
        ErrorMessage error = myArray.get(10).getError();
        assertEquals("Incorrect error " + error + " returned.", ErrorMessage.EMPTY_STRUCTURE, error);
        
        // Add 20 Integer objects.
        for(int i = 0; i < 20; i++){myArray.add(i);}
        
        // Test getting the object at index 10.
        Integer result = (Integer) myArray.get(10).getReturnValue();
        assertEquals("Incorrect value returned.", (Integer)10, result);
        
        // Test getting an out of bounds index number.
        error = myArray.get(100).getError();
        assertEquals("Incorrect error " + error + " returned.", ErrorMessage.INDEX_OUT_OF_BOUNDS, error);
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
        // Test getting an object from empty array.
        ErrorMessage error = myArray.remove(10).getError();
        assertEquals("Incorrect error " + error + " returned.", ErrorMessage.EMPTY_STRUCTURE, error);
        
        // Add 20 items to the list.
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        
        // Check the correct value & size are returned.
        myArray.remove(10);
        int value = (Integer) myArray.get(10).getReturnValue();
        int size = myArray.size();
        assertEquals("The value returned is incorrect.", 11, value);
        assertEquals("The size of the List is incorrect.", 19, size);
        
        // Check removing the first position.
        myArray.remove(0);
        value = (Integer) myArray.get(0).getReturnValue();
        assertEquals("The value returned is incorrect.", 1, value);
        
        // Test removing an out of bounds index number.
        error = myArray.remove(100).getError();
        assertEquals("Incorrect error " + error + " returned.", ErrorMessage.INDEX_OUT_OF_BOUNDS, error);
        
        // Remove remaining objects.
        for(int i = 18; i > 0; i--){
            myArray.remove(0);
        }
        // Test list is empty after objects removed.
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
    
}