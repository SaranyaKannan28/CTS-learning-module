import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) {
        try {
            // Load the Example class dynamically
            Class<?> cls = Class.forName("Example");

            // Create an instance of the Example class
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get all declared methods
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("Methods found in Example class:");

            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());

                // Print parameter types
                Class<?>[] paramTypes = method.getParameterTypes();
                System.out.print("Parameters: ");
                for (Class<?> param : paramTypes) {
                    System.out.print(param.getSimpleName() + " ");
                }
                System.out.println();

                // Dynamically call greet() with a parameter
                if (method.getName().equals("greet")) {
                    method.invoke(obj, "Saran");
                }

                // Dynamically call add() with two parameters
                if (method.getName().equals("add")) {
                    Object result = method.invoke(obj, 5, 7);
                    System.out.println("add(5, 7) = " + result);
                }

                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
