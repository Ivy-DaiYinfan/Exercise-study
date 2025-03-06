package exercise5;
public class Slice_o_Heaven {
   
        public String storeName;
        public String storeAddress;
        public String storeEmail;
        public String storePhone;
        private String storeMenu;
            
        public String pizzaIngredients;
        public double pizzaPrice;
            
        public String sides;
        public String drinks;
            
        private String orderID;
        private double orderTotal;
        
        public static final String DEF_ORDER_ID = "DEF-SOH-099";
        public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
        public static final double DEF_ORDER_TOTAL = 15.00;
        
        public Slice_o_Heaven() {
            this.orderID = DEF_ORDER_ID;
            this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
            this.orderTotal = DEF_ORDER_TOTAL;
            this.sides = "";
            this.drinks = "";
        }
        
        public Slice_o_Heaven(String orderID, String pizzaIngredients, double orderTotal) {
            this.orderID = orderID;
            this.pizzaIngredients = pizzaIngredients;
            this.orderTotal = orderTotal;
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
        
        public void takeOrder(String id, String ingredients, double total) {
            this.orderID = id;
            this.pizzaIngredients = ingredients;
            this.orderTotal = total;
            System.out.println("Order accepted!");
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
            System.out.println("Order Total: " + orderTotal);
        }
        
        public void displayReceipt() {
            printReceipt();
        }
        
      
            
        public static void processCardPayment(String cardNumber, String expiryDate, int cvv) {
                
            int cardLength = cardNumber.length();
            if (cardLength == 14) {
                System.out.println("Card accepted");
            } else {
                System.out.println("Invalid card");
                return;
            }
        
                
            int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        
                
            String blacklistedNumber = "12345678901234";
            if (cardNumber.equals(blacklistedNumber)) {
                System.out.println("Card is blacklisted. Please use another card");
                return;
            }
        
                
            int lastFourDigits = Integer.parseInt(cardNumber.substring(cardLength - 4));
        
                
            String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1, cardLength - 4).replaceAll(".", "*") + cardNumber.substring(cardLength - 4);
            System.out.println("Displayable card number: " + cardNumberToDisplay);
        }
        
            
        public static void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
            
            StringBuilder sb = new StringBuilder();
            sb.append("Pizza of the day: ").append(pizzaOfTheDay)
               .append(", Side of the day: ").append(sideOfTheDay)
               .append(", Special price: ").append(specialPrice);
               System.out.println(sb.toString());
            }
        
           

    

