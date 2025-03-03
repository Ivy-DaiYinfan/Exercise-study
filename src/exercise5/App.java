package exercise5;

public class App {
    public static void main(String[] args) {
        Slice_o_Heaven pizzeria = new Slice_o_Heaven();
        pizzeria.storeName = "Slice-o-Heaven";
        pizzeria.takeOrder("1", "Pepperoni, Cheese", 18.99);
        pizzeria.makePizza();
        pizzeria.displayReceipt();
        Slice_o_Heaven.processCardPayment("12345678901234", "12/25", 123);
        Slice_o_Heaven.specialOfTheDay("Pepperoni Pizza", "Fries", "$10");
    }
}
        
        
            
                                        
                      
