abstract class vehicle{ //abstract class
    abstract void run();
}
class car extends vehicle{ //concrete class
    void run() {
        System.out.println("Car running...");
    }
}
public class Abstraction {
    public static void main(String[] args) {
        vehicle v = new car(); //->obj created for concrete class with abstract class reference
        v.run();
    }
}
