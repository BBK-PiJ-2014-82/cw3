/**
 * This is an implementation of the List interface using a Linked List.
 * 
 * @author James
 */
public class LinkedList implements List {
    
    /**
     * This is the head node of the LinkedList.
     */
    private Node head;
    
    /**
     * This integer records the size of the LinkedList.
     */
    protected int size = 0;
    
    /**
     * This integer records the current position while traversing the list.
     */
    private int position = 0;
    
    /**
     * Class Constructor.
     */
    public void LinkedList(){}
    
    @Override
    public boolean isEmpty(){return size == 0;}
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public ReturnObject get(int index){
        ReturnObject returnItem;
        if(index < 0 || index > size){
            if(size == 0){
                returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            } else {
                returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            }
            return returnItem;
        } else {
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
        ReturnObject returnItem;
        if(index < 0 || index > size){
            if(size == 0){
                returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            } else {
                returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            }
            return returnItem;
        } else {
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
        ReturnObject returnItem;
        if(item == null){
            returnItem = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return returnItem;
        } else {
            if(index < 0 || index > size){
                if(size == 0){
                    returnItem = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
                } else {
                    returnItem = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
                }
                return returnItem;
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
                returnItem = new ReturnObjectImpl();
                return returnItem;
            }
        }
    }
    
    @Override
    public ReturnObject add(Object item){
        ReturnObject returnItem;
        if(item == null){
            returnItem = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return returnItem;
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
            returnItem = new ReturnObjectImpl();
            return returnItem;
        }
    }
    
    /**
     * Class for nodes of the list that wrap the objects making up the list.
     */
    private class Node{
        Object item;
        Node next;
    }
}