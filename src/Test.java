public class Test {

    public static void main(String[] args) {
        
        // Test creating new object
        ArrayList myArray = new ArrayList();
        
        // Test new array is empty
        if(myArray.isEmpty()){
            System.out.println("Test 1 : Working.");
        } else {
            System.out.println("Test 1 : Failed.");
        }
        
        // Add objects
        for(int i = 0; i < 20; i++){
            Integer number = i;
            myArray.add(number);
        }
        
        // Test addition of objects and size method
        if(myArray.size() == 20){
            System.out.println("Test 2 : Working.");
        } else {
            System.out.println("Test 2 : Failed.");
        }
        
        // Test get method
        if(myArray.get(10).equals(11)){
            System.out.println("Test 3 : Working.");
        } else {
            System.out.println("Test 3 : Failed.");
        }
        
        // Test remove method
        myArray.remove(10);
        if(!myArray.get(10).equals(11) && myArray.size() == 19){
            System.out.println("Test 4 : Working.");
        } else {
            System.out.println("Test 4 : Failed.");
        }
        
        
        
    }
}