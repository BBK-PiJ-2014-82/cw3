public class ImprovedStackImpl implements ImprovedStack {

    List baseList;
    
    public ImprovedStackImpl(List list){
        baseList = list;
    }
    
    @Override
    public ImprovedStack reverse() {
        List newList = new ArrayList();
        for(int i = baseList.size()-1; i > -1 ; i--){
            newList.add(baseList.get(i));
        }
        ImprovedStack newStack = new ImprovedStackImpl(newList);
        return newStack;
    }

    @Override
    public void remove(Object object) {
        for(int i = 0; i < baseList.size(); i++){
            if(baseList.equals(object)){
                baseList.remove(i);
                i = 0;
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
        return baseList.get(0);
    }

    @Override
    public ReturnObject pop() {
        return baseList.remove(0);
    }
    
}