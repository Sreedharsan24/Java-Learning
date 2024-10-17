//Switch Statement
public class Switchcase {
    public static void main(String args[]) {
        int n = 3;

        switch (n) {
            case 1:
                System.out.println("ONE");
                break; // breaks out of the switch
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            default: // runs some  specified code if there is no match
                System.out.println("Not found");
                break;
        }
    }
}
