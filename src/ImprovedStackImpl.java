/**
 * This is an implementation of ImprovedStack.
 * 
 * @author James
 */
public class ImprovedStackImpl implements ImprovedStack {

    List baseList;
    
    /**
     * Class Constructor.
     * 
     * @param list A List that will form the basis of the new stack.
     */
    public ImprovedStackImpl(List list){
        baseList = list;
    }
    
    @Override
    public ImprovedStack reverse() {
        List newList = new ArrayList();
        
        // Reverse the array.
        for(int i = baseList.size()-1; i > -1 ; i--){
            newList.add(baseList.get(i).getReturnValue());
        }
        
        // Create and return the new stack.
        ImprovedStack newStack = new ImprovedStackImpl(newList);
        return newStack;
    }

    @Override
    public void remove(Object object) {
        for(int i = baseList.size()-1; i >= 0 ; i--){
            if(baseList.get(i).getReturnValue().equals(object)){
                baseList.remove(i);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return baseList.isEmpty();
    }

    @Override
    public int size() {
        return baseList.size();
    }

    @Override
    public void push(Object item) {
        baseList.add(item);
    }

    @Override
    public ReturnObject top() {
        return baseList.get(size()-1);
    }

    @Override
    public ReturnObject pop() {
        return baseList.remove(size()-1);
    }
    
}