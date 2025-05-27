public class Example {
        public int add(int a, int b) {
            return a + b;
        }

        public static void main(String[] args) {
            Example ex = new Example();
            System.out.println("Sum: " + ex.add(5, 3));
        }
    }
