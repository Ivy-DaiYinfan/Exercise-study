package exercise5new;

public class App {
    
     public static void main(String[] args) {
        Slice_o_Heaven pizzaStore = new Slice_o_Heaven();
        try {
            pizzaStore.takeOrder("SOH-123", "Pepperoni, Mushrooms", 20.00);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        pizzaStore.makePizza();
        pizzaStore.displayReceipt();

        Slice_o_Heaven.processCardPayment("12345678901234", "12/25", 123);
        Slice_o_Heaven.specialOfTheDay("Margherita Pizza", "Garlic Bread", "$12.99");
    }                                                                                  
}
