import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class foodOrder {
    private final List<orders> orderList = Collections.synchronizedList(new ArrayList<>());

    public synchronized void placeOrder(orders orderedFood) {
        orderList.add(orderedFood);
    }

    public void getAllOrders() {
        System.out.println("All Orders:");
        for (orders order: orderList) {
            System.out.println(order);
        }
    }
}
