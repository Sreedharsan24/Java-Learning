public class IfElse {
    public static void main(String args[]) {
        int n = 7;

        if (n == 0) // Nothing entered will be printed if it satisfies n==0
        {
            System.out.println("Nothing");
            System.out.println("entered");
        }  // more than one statement to be printed we can use curly braces

        else if (n % 2 == 0)
            System.out.println("Even");

        else
            System.out.println("Odd");

        //Ternary operator
        // ?: -> condition?expr1:expr2

    }


}
