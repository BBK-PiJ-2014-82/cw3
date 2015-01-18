public class StackImpl extends AbstractStack {

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
            ReturnObjectImpl empty = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return empty;
        } else {
            ReturnObjectImpl item = new ReturnObjectImpl(internalList.get(0).getReturnValue());
            return item;
        }
    }

    @Override
    public ReturnObject pop() {
        if(internalList.isEmpty()){
            ReturnObjectImpl empty = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            return empty;
        } else {
            ReturnObjectImpl item = new ReturnObjectImpl(internalList.remove(0).getReturnValue());
            return item;
        }
    }
    
}