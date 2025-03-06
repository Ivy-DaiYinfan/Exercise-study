package exercise6;

import java.util.Scanner;

public class App {
     public static void main(String[] args) {
        Slice_o_Heaven pizzaStore = new Slice_o_Heaven();

        pizzaStore.takeOrder();
        if (pizzaStore.wantDiscount.equalsIgnoreCase("Y")) {
            pizzaStore.isItYourBirthday();
        } else {
            pizzaStore.makeCardPayment();
        }
        pizzaStore.makePizza();
        pizzaStore.displayReceipt();
        Slice_o_Heaven.specialOfTheDay("Special Pizza", "Fries", "$10.99");

        pizzaStore.closeScanner(); 
    }
}