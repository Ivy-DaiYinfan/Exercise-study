package exercise6;

import java.util.Scanner;

public class Slice_o_Heaven {

    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public String storePhone;
    private String storeMenu;

    public String pizzaIngredients;
    public double pizzaPrice;
    public String pizzaSize;
    public String extraCheese;
    public String sideDish;
    public String drinks;
    public String wantDiscount;

    private String orderID;
    private double orderTotal;

    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;
    private static final long BLACKLISTED_CARD_NUMBER = 12345678901234L;

    private Scanner scanner; 

    public Slice_o_Heaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sideDish = "";
        this.drinks = "";
        this.scanner = new Scanner(System.in);
    }

    public Slice_o_Heaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.scanner = new Scanner(System.in); 
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

   
    public void takeOrder() {
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String[] ingredients = scanner.nextLine().split(" ");
        while (ingredients.length != 3) {
            System.out.println("Please enter exactly three ingredients. Try again.");
            ingredients = scanner.nextLine().split(" ");
        }
        this.pizzaIngredients = String.join(", ", ingredients);

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSizeInput = scanner.nextLine();
        while (!(pizzaSizeInput.equalsIgnoreCase("Small") || pizzaSizeInput.equalsIgnoreCase("Medium") || pizzaSizeInput.equalsIgnoreCase("Large"))) {
            System.out.println("Invalid pizza size entered. Please try again.");
            pizzaSizeInput = scanner.nextLine();
        }
        this.pizzaSize = pizzaSizeInput;

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheeseInput = scanner.nextLine();
        while (!(extraCheeseInput.equalsIgnoreCase("Y") || extraCheeseInput.equalsIgnoreCase("N"))) {
            System.out.println("Please enter Y or N for extra cheese option. Try again.");
            extraCheeseInput = scanner.nextLine();
        }
        this.extraCheese = extraCheeseInput;

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDishInput = scanner.nextLine();
        while (!(sideDishInput.equalsIgnoreCase("Calzone") || sideDishInput.equalsIgnoreCase("Garlic bread") || sideDishInput.equalsIgnoreCase("None"))) {
            System.out.println("Invalid side dish entered. Please try again.");
            sideDishInput = scanner.nextLine();
        }
        this.sideDish = sideDishInput;

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        String drinksInput = scanner.nextLine();
        while (!(drinksInput.equalsIgnoreCase("Cold Coffee") || drinksInput.equalsIgnoreCase("Cocoa drink") || drinksInput.equalsIgnoreCase("Coke") || drinksInput.equalsIgnoreCase("None"))) {
            System.out.println("Invalid drink option entered. Please try again.");
            drinksInput = scanner.nextLine();
        }
        this.drinks = drinksInput;

       
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        this.wantDiscount = scanner.next();
        while (!(this.wantDiscount.equalsIgnoreCase("Y") || this.wantDiscount.equalsIgnoreCase("N"))) {
            System.out.println("Invalid input for discount option. Please try again.");
            this.wantDiscount = scanner.next();
        }
        scanner.nextLine();
    }

   
    public void makePizza() {
        System.out.println("Making pizza with " + pizzaIngredients);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Pizza is ready!");
    }

   
    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Store Name: " + storeName);
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Pizza Size: " + pizzaSize);
        System.out.println("Extra Cheese: " + extraCheese);
        System.out.println("Side Dish: " + sideDish);
        System.out.println("Drinks: " + drinks);
        System.out.println("Order Total: " + orderTotal);
    }

   
    public void displayReceipt() {
        printReceipt();
    }

   
    public String getStoreMenu() {
        return storeMenu;
    }

    
    public void setStoreMenu(String storeMenu) {
        this.storeMenu = storeMenu;
    }

   
    public void isItYourBirthday() {
        System.out.println("Enter your birthday (format: yyyy-MM-dd):");
        String birthdateStr = scanner.nextLine();

        System.out.println("You can");
        orderTotal /= 2;
    }

    
    public void makeCardPayment() {
    }

  
    public static void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        if (!isCardNumberLengthValid(cardNumberStr)) {
            System.out.println("Invalid card");
            return;
        }

        if (isCardBlacklisted(cardNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }

        try {
            long firstCardDigit = Long.parseLong(cardNumberStr.substring(0, 1));
            long lastFourDigits = Long.parseLong(cardNumberStr.substring(cardNumberStr.length() - 4));
            String cardNumberToDisplay = cardNumberStr.charAt(0) + cardNumberStr.substring(1, cardNumberStr.length() - 4).replaceAll(".", "*") + cardNumberStr.substring(cardNumberStr.length() - 4);
            System.out.println("Displayable card number: " + cardNumberToDisplay);
        } catch (NumberFormatException e) {
            System.out.println("Invalid card number format");
        }
    }

    
    private static boolean isCardNumberLengthValid(String cardNumber) {
        return cardNumber.length() == 14;
    }

    
    private static boolean isCardBlacklisted(long cardNumber) {
        return cardNumber == BLACKLISTED_CARD_NUMBER;
    }

    
    public static void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza of the day: ").append(pizzaOfTheDay)
           .append(", Side of the day: ").append(sideOfTheDay)
           .append(", Special price: ").append(specialPrice);
        System.out.println(sb.toString());
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}