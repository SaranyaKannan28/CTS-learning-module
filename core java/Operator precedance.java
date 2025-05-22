public class OperatorPrecedenceDemo {
    public static void main(String[] args) {
        int a = 10, b = 5, c = 2;
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println();

        int result1 = a + b * c;            
        int result2 = (a + b) * c;             
        int result3 = a + b - c * 3;           
        int result4 = a + b / c + a * b;       
        int result5 = a++ + --b * c;          


        System.out.println("Expression 1: a + b * c = " + result1);
        System.out.println("Explanation: b * c = " + (b * c) + " → a + (b * c) = " + result1);
        System.out.println();

        System.out.println("Expression 2: (a + b) * c = " + result2);
        System.out.println("Explanation: a + b = " + (a + b) + " → (a + b) * c = " + result2);
        System.out.println();

        System.out.println("Expression 3: a + b - c * 3 = " + result3);
        System.out.println("Explanation: c * 3 = " + (c * 3) + ", a + b = " + (a + b) + " → (a + b) - (c * 3) = " + result3);
        System.out.println();

        System.out.println("Expression 4: a + b / c + a * b = " + result4);
        System.out.println("Explanation: b / c = " + (b / c) + ", a * b = " + (a * b) + " → a + (b / c) + (a * b) = " + result4);
        System.out.println();

        System.out.println("Expression 5: a++ + --b * c = " + result5);
        System.out.println("Explanation: --b = " + b + ", --b * c = " + (b * c) + ", a++ = " + (a - 1) + " → (a++) + (--b * c) = " + result5);
    }
}
