public class Example {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Main method to test the add method
    public static void main(String[] args) {
        Example example = new Example();
        int result = example.add(5, 7);
        System.out.println("Sum of 5 and 7 is: " + result);
    }
}
