import cw3.ErrorMessage;
import cw3.LinkedList;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import static cw3.ErrorMessage.*;

public class LinkedListTest {
    
    LinkedList myArray;
    
    @Before
    public void createList(){
        myArray = new LinkedList();
    }
    
    @Test
    public void testIsEmpty(){
        boolean result = myArray.isEmpty();
        assertTrue("New List is not empty after construction.", result);
    }
    
    @Test
    public void testAddObject(){
        // Test adding integer.
        myArray.add(100);
        boolean result = myArray.isEmpty();
        assertFalse("New List is empty after add().", result);
        
        // Test adding a null object.
        ErrorMessage error = myArray.add(null).getError();
        assertEquals("Incorrect error " + error + " returned.", INVALID_ARGUMENT, error);
    }
    
    @Test
    public void testGet(){
        // Test getting an object from empty array.
        ErrorMessage error = myArray.get(10).getError();
        assertEquals("Incorrect error " + error + " returned.", EMPTY_STRUCTURE, error);
        
        // Add 20 objects.
        for(int i = 0; i < 20; i++){
            myArray.add(i);
        }
        
        // Test getting the object at element 10.
        Integer result = (Integer) myArray.get(10).getReturnValue();
        assertEquals("Incorrect value returned.", (Integer)10, result);
        
        // Test getting an out of bounds index number.
        error = myArray.get(100).getError();
        assertEquals("Incorrect error " + error + " returned.", INDEX_OUT_OF_BOUNDS, error);
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
        myArray.remove(0);
        value = (Integer) myArray.get(0).getReturnValue();
        assertEquals("The value returned is incorrect.", 1, value);
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
    
}