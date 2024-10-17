import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class orders {

    private static int idCounter = 1;
    private final int id;
    private final String food;

    public orders(String food) {
        synchronized(orders.class){
            this.id = idCounter++;
        }
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public String getFood() {
        return food;
    }
    
    public String toString() {
        return "Order ID: " + id + ", Food: " + food;
    }

}
