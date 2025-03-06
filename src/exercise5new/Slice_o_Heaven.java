package exercise5new;

// 

/**
 * 该类用于模拟名为Slice-o-Heaven的披萨店相关业务逻辑。
 * 包含店铺信息、订单信息以及相关操作方法。
 */
public class Slice_o_Heaven {

    // 店铺名称
    public String storeName;
    // 店铺地址
    public String storeAddress;
    // 店铺邮箱
    public String storeEmail;
    // 店铺电话
    public String storePhone;
    // 店铺菜单，私有变量，需通过get和set方法访问
    private String storeMenu;

    // 披萨配料
    public String pizzaIngredients;
    // 披萨价格
    public double pizzaPrice;

    // 配菜
    public String sides;
    // 饮料
    public String drinks;

    // 订单编号，私有变量，需通过get和set方法访问
    private String orderID;
    // 订单总价，私有变量，需通过get和set方法访问
    private double orderTotal;

    // 默认订单编号常量
    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    // 默认披萨配料常量
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    // 默认订单总价常量
    public static final double DEF_ORDER_TOTAL = 15.00;

    /**
     * 无参构造方法，用于初始化对象的默认值。
     * 将订单编号、披萨配料、订单总价设置为默认常量值，配菜和饮料初始化为空字符串。
     */
    public Slice_o_Heaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    /**
     * 有参构造方法，根据传入的参数初始化对象。
     * @param orderID 订单编号
     * @param pizzaIngredients 披萨配料
     * @param orderTotal 订单总价
     */
    public Slice_o_Heaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    /**
     * 获取订单编号的方法。
     * @return 订单编号
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * 设置订单编号的方法。
     * @param orderID 要设置的订单编号
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * 获取订单总价的方法。
     * @return 订单总价
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * 设置订单总价的方法。
     * @param orderTotal 要设置的订单总价
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * 接受订单的方法，更新订单的相关信息。
     * 对传入的订单编号、披萨配料和订单总价进行有效性检查，若不合法则抛出异常。
     * @param id 订单编号
     * @param ingredients 披萨配料
     * @param total 订单总价
     * @throws IllegalArgumentException 如果输入的参数不合法
     */
    public void takeOrder(String id, String ingredients, double total) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("Pizza ingredients cannot be null or empty");
        }
        if (total < 0) {
            throw new IllegalArgumentException("Order total cannot be negative");
        }
        this.orderID = id;
        this.pizzaIngredients = ingredients;
        this.orderTotal = total;
        System.out.println("Order accepted!");
    }

    /**
     * 模拟制作披萨的过程，打印制作信息并暂停3秒模拟制作耗时。
     */
    public void makePizza() {
        System.out.println("Making pizza with " + pizzaIngredients);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Pizza is ready!");
    }

    /**
     * 打印订单收据的私有方法，包含店铺名称、订单编号、披萨配料和订单总价。
     * 该方法只能在类内部被调用。
     */
    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Store Name: " + storeName);
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
    }

    /**
     * 显示订单收据的方法，调用私有方法printReceipt()来打印收据。
     */
    public void displayReceipt() {
        printReceipt();
    }

    /**
     * 获取店铺菜单的方法。
     * @return 店铺菜单
     */
    public String getStoreMenu() {
        return storeMenu;
    }

    /**
     * 设置店铺菜单的方法。
     * @param storeMenu 要设置的店铺菜单
     */
    public void setStoreMenu(String storeMenu) {
        this.storeMenu = storeMenu;
    }

    /**
     * 处理信用卡支付的方法，根据信用卡号进行一系列验证和操作。
     * @param cardNumber 信用卡号码
     * @param expiryDate 信用卡有效期
     * @param cvv 信用卡安全码
     */
    public static void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        // 检查信用卡号码长度是否为14
        if (!isValidCardLength(cardNumber)) {
            System.out.println("Invalid card");
            return;
        }
        // 检查信用卡是否在黑名单中
        if (isBlacklistedCard(cardNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }
        try {
            // 提取信用卡号的第一个字符并转换为整数
            int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
            // 提取信用卡号的最后四个字符并转换为整数
            int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));
            // 格式化信用卡号，只显示第一个字符和最后四个字符，中间用*替换
            String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1, cardNumber.length() - 4).replaceAll(".", "*") + cardNumber.substring(cardNumber.length() - 4);
            System.out.println("Displayable card number: " + cardNumberToDisplay);
        } catch (NumberFormatException e) {
            System.out.println("Invalid card number format");
        }
    }

    /**
     * 验证信用卡号码长度是否有效的私有方法。
     * @param cardNumber 信用卡号码
     * @return 如果长度为14则返回true，否则返回false
     */
    private static boolean isValidCardLength(String cardNumber) {
        return cardNumber.length() == 14;
    }

    /**
     * 验证信用卡是否为黑名单卡的私有方法。
     * @param cardNumber 信用卡号码
     * @return 如果是黑名单卡则返回true，否则返回false
     */
    private static boolean isBlacklistedCard(String cardNumber) {
        String blacklistedNumber = "12345678901234";
        return cardNumber.equals(blacklistedNumber);
    }

    /**
     * 输出当天特价套餐信息的方法，接受披萨、配菜和特价的参数并展示。
     * @param pizzaOfTheDay 当天的披萨
     * @param sideOfTheDay 当天的配菜
     * @param specialPrice 特价套餐价格
     */
    public static void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza of the day: ").append(pizzaOfTheDay)
           .append(", Side of the day: ").append(sideOfTheDay)
           .append(", Special price: ").append(specialPrice);
        System.out.println(sb.toString());
    }
}