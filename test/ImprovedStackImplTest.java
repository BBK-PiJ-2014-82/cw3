import cw3.ErrorMessage;
import static cw3.ErrorMessage.EMPTY_STRUCTURE;
import cw3.ImprovedStackImpl;
import cw3.FunctionalLinkedList;
import cw3.ImprovedStack;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImprovedStackImplTest {
    
    ImprovedStack stack;
    
    @Test
    public void testIsEmpty(){
        // Create new stack.
        FunctionalLinkedList newList = new FunctionalLinkedList();
        stack = new ImprovedStackImpl(newList);
        
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
        stack = new ImprovedStackImpl(newList);
        
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
        stack = new ImprovedStackImpl(newList);
        
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
        stack = new ImprovedStackImpl(newList);
        for(int i = 1; i < 101; i++){
            stack.push(i * 10);
        }
        
        // Check the top of the stack is correct value.
        int top = (Integer) stack.top().getReturnValue();
        assertEquals("Top result is incorrect.", 1000, top);
        
        // Check size is correct after top.
        assertEquals("The size is not correct.", 100, stack.size());
        
        // Check that correct error is returned from the top of an empty stack.
        for(int i = 100; i > 0; i--){
            stack.pop();
        }
        ErrorMessage error = stack.top().getError();
        assertEquals("A correct error message is not returned.", EMPTY_STRUCTURE, error);
    }
    
    @Test
    public void testPop(){
        // Create a new list.
        FunctionalLinkedList newList = new FunctionalLinkedList();        
        stack = new ImprovedStackImpl(newList);
        for(int i = 1; i < 101; i++){
            stack.push(i * 10);
        }
        
        // Check that popping an element leave the correct element on top.
        stack.pop();
        int pop = (Integer) stack.pop().getReturnValue();
        assertEquals("Initial pop did not work correctly.", 990, pop);
        
        // Check that the size after popping is correct.
        int size = stack.size();
        assertEquals("Stack is not the correct size.", 98, size);
        
        // Check that correct error is returned from popping an empty stack.
        for(int i = 98; i > 0; i--){
            stack.pop();
        }
        ErrorMessage error = stack.pop().getError();
        assertEquals("A correct error message is not returned.", EMPTY_STRUCTURE, error);
    }
    
    @Test
    public void testReverse(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 1; i < 101; i++){
            newList.add(i * 15);
        }
        stack = new ImprovedStackImpl(newList);
        ImprovedStackImpl newStack;
        newStack = (ImprovedStackImpl) stack.reverse();
        int j;
        for(int i = 100; i > 0; i--){
            j = (Integer) newStack.pop().getReturnValue();
            assertEquals("Numbers at loop "+ i +" is not correct.", i * 15, j);
        }
    }
    
    @Test
    public void testRemove(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 1; i < 101; i++){
            if(i%2 == 1){
                newList.add("Odd");
            } else {
                newList.add("Even");
            }
        }
        stack = new ImprovedStackImpl(newList);
        stack.remove("Odd");
        assertEquals("Size of list is incorrect.", 50, stack.size());
        for(int i = 0; i < stack.size(); i++){
            String even = (String) stack.pop().getReturnValue();
            assertEquals("'Odd' not removed at loop "+ i +".", "Even", even);
        }
    }
    
}