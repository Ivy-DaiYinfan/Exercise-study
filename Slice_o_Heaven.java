public class Slice_o_Heaven{
    public String storeAddress;

    private String storeMenu;
    
    public String storeName;
    public long storePhone;
    public String storeEmail;
    public String pizzaIngredints;
    public double pizzaPrice;
    public String sides;
    public String drinks;

    private String orderID;
    private double orderTotal;

    public final String DEF_ORDER_ID = DEF-SOH-99;
    public final String DEF_PIZZA_INGREDIENTS ;
    public final double DEF_ORDER_TOTAL;


    public void takeOrder(String id,double total){
        orderID = id;
        orderTotal = total;

        System.out.println("Order is accepted!");
        System.out.println("Order is being prepared.");
        
        makePizza(pizzaIngredints);
        try{
            Thread.sleep(5000);/*5seconds */
           
        }catch(InterruptedException e){
            System.out.println("Your order is ready for pickup");
        }

        System.out.println("Your order is ready");
        
        printReceipt();


    }

    private void makePizza(String ingredients){
        pizzaIngredints = ingredients;
        System.out.println("Your pizza  is making.");
    }

    private void printReceipt(){
        System.out.println("******RECEIPPT******");

        System.out.println("Order ID"+orderID);
        System.out.println("Order Details"+pizzaIngredints);
        System.out.println("Order Total"+orderTotal);

    }

    //


    public Slice_o_Heaven(){
        
    }


}
