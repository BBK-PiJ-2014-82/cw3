public class LinkedList implements List {
    
    private Node head = new Node();
    private int size = 0;
    private int position = 0;
    
    public void LinkedList(){}
    
    public boolean isEmpty(){if (size == 0){return true;} else {return false;}}
    
    public int size(){
        return size;
    }
    
    public ReturnObject get(int index){
        
    }
    
    public ReturnObject remove(int index){
        
    }
    
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
                Node runner = head.next;
                Node previous = head;
                while(index != position){
                    previous = runner;
                    runner = runner.next;
                    position++;
                }
                newNode.next = runner;
                previous.next = newNode;
                size++;
                position = 0;
                ReturnObjectImpl empty = new ReturnObjectImpl();
                return empty;
            }
        }
    }
    
    public ReturnObject add(Object item){
        if(item == null){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return error;
        } else {
            if(head.item == null){
                head.item = item;
            } else {
                Node newNode = new Node();
                newNode.item = item;
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