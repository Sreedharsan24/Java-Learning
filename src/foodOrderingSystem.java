
public class foodOrderingSystem {
    public static void main(String[] args) {

        foodOrder fodD = new foodOrder();

        Thread user1 = new Thread(() -> {
            orders newOrder = new orders("Pizza");
            fodD.placeOrder(newOrder);

            System.out.println("Token: "+ newOrder.getId() +"\nThe Ordered Food: " + newOrder.getFood());
        });
        Thread user2 = new Thread(new Runnable()
        {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                orders newOrder = new orders("Burger");
                fodD.placeOrder(newOrder);

                System.out.println("Token: "+ newOrder.getId() +"\nThe Ordered Food: " + newOrder.getFood());
            }
        });
        Thread user3 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            orders newOrder = new orders("Briyani");
            fodD.placeOrder(newOrder);

            System.out.println("Token: "+ newOrder.getId() +"\nThe Ordered Food: " + newOrder.getFood());
        });
        Thread user4 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            orders newOrder = new orders("Maggi");
            fodD.placeOrder(newOrder);

            System.out.println("Token: "+ newOrder.getId() +"\nThe Ordered Food: " + newOrder.getFood());
        });

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fodD.getAllOrders();
    }
}
