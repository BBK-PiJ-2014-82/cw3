import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackImplTest {
    
    StackImpl stack;
    
    @Test
    public void testIsEmpty(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        stack = new StackImpl(newList);
        boolean empty = stack.isEmpty();
        assertTrue("New Stack is not empty.", empty);
        stack.push(20);
        empty = stack.isEmpty();
        assertFalse("After push Stack is empty.", empty);
    }
    
    @Test
    public void testSize(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 0; i < 200; i++){
            newList.add(i * 10);
        }
        stack = new StackImpl(newList);
        int size = stack.size();
        assertEquals("New Stack is wrong size.", 200, size);
        for(int i = 100; i > 0; i--){
            stack.pop();
        }
        size = stack.size();
        assertEquals("Stack is wrong size after popping.", 100, size);
    }
    
    @Test
    public void testPush(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 0; i < 100; i++){
            newList.add(i * 10);
        }
        stack = new StackImpl(newList);
        for(int i = 100; i < 200; i++){
            stack.push(i * 10);
        }
        int size = stack.size();
        assertEquals("New Stack is wrong size.", 200, size);
    }
    
    @Test
    public void testTop(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 1; i < 101; i++){
            newList.add(i * 15);
        }
        stack = new StackImpl(newList);
        int top = (Integer) stack.top().getReturnValue();
        assertEquals("Top result is incorrect.", 15, top);
    }
    
    @Test
    public void testPop(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        for(int i = 1; i < 101; i++){
            newList.add(i * 15);
        }
        stack = new StackImpl(newList);
        stack.pop().getReturnValue();
        int pop = (Integer) stack.pop().getReturnValue();
        assertEquals("Initial pop did not work correctly.", 30, pop);
    }
    
}