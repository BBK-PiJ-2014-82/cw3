public class LinkedList implements List {
    
    private Node head;
    protected int size = 0;
    private int position = 0;
    
    public void LinkedList(){}
    
    @Override
    public boolean isEmpty(){return size == 0;}
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public ReturnObject get(int index){
        if(index < 0 || index > size){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return error;
        } else {
            ReturnObjectImpl returnItem;
            Node runner = head;
            while(index != position){
                runner = runner.next;
                position++;
            }
            returnItem = new ReturnObjectImpl(runner.item);
            position = 0;
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject remove(int index){
        if(index < 0 || index > size){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return error;
        } else {
            ReturnObjectImpl returnItem;
            Node runner = head;
            Node previous = head;
            while(index != position){
                previous = runner;
                runner = runner.next;
                position++;
            }
            returnItem = new ReturnObjectImpl(runner.item);
            if(index == 0){
                head = runner.next;
            } else {
                previous.next = runner.next;
            }
            position = 0;
            size--;
            return returnItem;
        }
    }
    
    @Override
    public ReturnObject add(int index, Object item){
        if(item == null){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return error;
        } else {
            if(index < 0 || index > size){
                ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
                return error;
            } else {
                Node newNode = new Node();
                newNode.item = item;
                Node runner = head;
                Node previous = head;
                while(index != position){
                    previous = runner;
                    runner = runner.next;
                    position++;
                }
                newNode.next = runner;
                previous.next = newNode;
                position = 0;
                size++;
                ReturnObjectImpl empty = new ReturnObjectImpl();
                return empty;
            }
        }
    }
    
    @Override
    public ReturnObject add(Object item){
        if(item == null){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return error;
        } else {
            Node newNode = new Node();
            newNode.item = item;
            if(head == null){
                head = newNode;
            } else {
                Node runner = head;
                while(runner.next != null){
                    runner = runner.next;
                    position++;
                }
                runner.next = newNode;
                position = 0;
            }
            size++;
            ReturnObjectImpl empty = new ReturnObjectImpl();
            return empty;
        }
    }
    
    private class Node{
        Object item;
        Node next;
    }
}