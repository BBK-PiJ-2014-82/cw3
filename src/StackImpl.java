/**
 * This is an extension of AbstractStack.
 * 
 * @author James
 */
public class StackImpl extends AbstractStack {

    /**
     * Class Constructor.
     * 
     * @param list Any List that will be transformed into a stack.
     */
    public StackImpl(List list){
        super(list);
    }
    
    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public void push(Object item) {
        internalList.add(item);
    }

    @Override
    public ReturnObject top() {
        ReturnObject returnItem;
        if(internalList.isEmpty()){
            returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            returnItem = new ReturnObjectImpl(internalList.get(size()-1).getReturnValue());
        }
        return returnItem;
    }

    @Override
    public ReturnObject pop() {
        ReturnObject returnItem;
        if(internalList.isEmpty()){
            returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            returnItem = new ReturnObjectImpl(internalList.remove(size()-1).getReturnValue());
        }
        return returnItem;
    }
    
}