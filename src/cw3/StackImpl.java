package cw3;

import static cw3.ErrorMessage.*;

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
        if(internalList.isEmpty()){
            ReturnObjectImpl empty = new ReturnObjectImpl(EMPTY_STRUCTURE);
            return empty;
        } else {
            ReturnObjectImpl item = new ReturnObjectImpl(internalList.get(0).getReturnValue());
            return item;
        }
    }

    @Override
    public ReturnObject pop() {
        if(internalList.isEmpty()){
            ReturnObjectImpl empty = new ReturnObjectImpl(EMPTY_STRUCTURE);
            return empty;
        } else {
            ReturnObjectImpl item = new ReturnObjectImpl(internalList.remove(0).getReturnValue());
            return item;
        }
    }
    
}