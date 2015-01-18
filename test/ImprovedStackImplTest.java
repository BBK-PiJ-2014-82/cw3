import org.junit.Test;
import static org.junit.Assert.*;

public class ImprovedStackImplTest {
    
    ImprovedStackImpl stack;
    
    @Test
    public void testIsEmpty(){
        FunctionalLinkedList newList = new FunctionalLinkedList();
        stack = new ImprovedStackImpl(newList);
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
        stack = new ImprovedStackImpl(newList);
        int size = stack.size();
        assertEquals("New Stack is wrong size.", 200, size);
        for(int i = 100; i > 0; i--){
            stack.pop();
        }
        size = stack.size();
        assertEquals("Stack is wrong size after popping.", 100, size);
    }
    
}