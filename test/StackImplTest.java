import cw3.StackImpl;
import cw3.FunctionalLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackImplTest {
    
    StackImpl stack;
    
    @Test
    public void testIsEmpty(){
        // Create new stack.
        FunctionalLinkedList newList = new FunctionalLinkedList();
        stack = new StackImpl(newList);
        
        // Test new stack is empty.
        boolean empty = stack.isEmpty();
        assertTrue("New Stack is not empty.", empty);
        
        // Add element and check stack is not empty.
        stack.push(20);
        empty = stack.isEmpty();
        assertFalse("After push Stack is empty.", empty);
    }
    
    @Test
    public void testSizeAndPop(){
        // Create new list
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 0; i < 200; i++){
            newList.add(i * 10);
        }
        stack = new StackImpl(newList);
        
        // Check the size of the new stack.
        int size = stack.size();
        assertEquals("New Stack is wrong size.", 200, size);
        
        // Check the size after removing elements.
        for(int i = 100; i > 0; i--){
            stack.pop();
        }
        size = stack.size();
        assertEquals("Stack is wrong size after popping.", 100, size);
    }
    
    @Test
    public void testPush(){
        // Create new stack.
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 0; i < 100; i++){
            newList.add(i * 10);
        }
        stack = new StackImpl(newList);
        
        // Push elements onto new stack and check size.
        for(int i = 100; i < 200; i++){
            stack.push(i * 10);
        }
        int size = stack.size();
        assertEquals("New Stack is wrong size.", 200, size);
    }
    
    @Test
    public void testTop(){
        // Create new stack.
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 1; i < 101; i++){
            newList.add(i * 15);
        }
        stack = new StackImpl(newList);
        
        // Check the top of the stack is correct value.
        int top = (Integer) stack.top().getReturnValue();
        assertEquals("Top result is incorrect.", 15, top);
    }
    
    @Test
    public void testPop(){
        // Create a new stack.
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 1; i < 101; i++){
            newList.add(i * 15);
        }
        stack = new StackImpl(newList);
        
        // Check that popping an element leave the correct element on top.
        stack.pop();
        int pop = (Integer) stack.pop().getReturnValue();
        assertEquals("Initial pop did not work correctly.", 30, pop);
        
        // Check that the size after popping is correct.
        int size = stack.size();
        assertEquals("Stack is not the correct size.", 98, size);
    }
    
}