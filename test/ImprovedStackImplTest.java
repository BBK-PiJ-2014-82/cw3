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
    
}