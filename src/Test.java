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
        if(myArray.get(10).getReturnValue().equals(10)){
            System.out.println("Test 3 : Working.");
        } else {
            System.out.println("Test 3 : Failed.");
        }
        
        // Test remove method
        myArray.remove(10);
        if(myArray.get(10).getReturnValue().equals(11) && myArray.size() == 19){
            System.out.println("Test 4 : Working.");
        } else {
            System.out.println("Test 4 : Failed.");
        }
        
        // Test remove until all deleted
        // Add objects
        for(int i = myArray.size()-1; i >= 0; i--){
            Integer number = i;
            myArray.remove(number);
        }
        if(myArray.size() == 0){
            System.out.println("Test 5 : Working.");
        } else {
            System.out.println("Test 5 : Failed.");
        }
        
        // Test copy to new array
        for(int i = 0; i < 200; i++){
            Integer number = i;
            myArray.add(number);
        }
        if(myArray.size() == 200){
            System.out.println("Test 6 : Working.");
        } else {
            System.out.println("Test 6 : Failed.");
        }
        
        // Test adding with index
        for(int i = 0; i < 10; i++){
            Integer number = i;
            myArray.add(number+100, number);
        }
        if(myArray.size() == 210 && myArray.get(105).getReturnValue().equals(5)){
            System.out.println("Test 7 : Working.");
        } else {
            System.out.println("Test 7 : Failed.");
        }
        
        
        
    }
}