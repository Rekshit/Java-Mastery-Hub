import java.util.*;

// ======================================================= ABSTRACT FACTORY ====================================================================

interface Product {
    void showproduct();
}

// CLOTHING

class MenClothing implements Product {
    public void showproduct() {
        System.out.println("Men Clothing Product Selected");
        System.out.println("Pay: 1000 to buy T-Shirt");
        System.out.println("Pay: 3000 to buy Pants");
        System.out.println("Pay: 2000 to buy Shoes");
    }
}

class WomenClothing implements Product {
    public void showproduct() {
        System.out.println("Women Clothing Product Selected");
        System.out.println("Pay: 1000 to buy T-Shirt");
        System.out.println("Pay: 3000 to buy Trousers");
        System.out.println("Pay: 2000 to buy Skirt");
    }
}

class KidsClothing implements Product {
    public void showproduct() {
        System.out.println("Kids Clothing Product Selected");
        System.out.println("Pay: 1000 to buy T-Shirt");
        System.out.println("Pay: 3000 to buy Pants");
        System.out.println("Pay: 2000 to buy Shoes");
    }
}


// FURNITURE

class WoodenFurniture implements Product {
    public void showproduct() {
        System.out.println("Wooden Furniture Selected");
        System.out.println("Pay: 3000 to buy Chair");
        System.out.println("Pay: 5000 to buy Dining Table");
        System.out.println("Pay: 10000 to buy Bed");
    }
}

class PlasticFurniture implements Product {
    public void showproduct() {
        System.out.println("Plastic Furniture Selected");
        System.out.println("Pay: 1000 to buy Plastic Chair");
        System.out.println("Pay: 3000 to buy Kids Table");
        System.out.println("Pay: 2000 to buy Baskets");
    }
}

class GlassFurniture implements Product {
    public void showproduct() {
        System.out.println("Glass Furniture Selected");
        System.out.println("Pay: 10000 to buy Glass Table");
        System.out.println("Pay: 6000 to buy Crockery");
        System.out.println("Pay: 8000 to buy Mirror");
    }
}


// MOBILE

class AppleMobile implements Product {
    public void showproduct() {
        System.out.println("Apple Mobile Selected");
        System.out.println("Pay: 50000 to buy IPhone 16");
        System.out.println("Pay: 100000 to buy IPhone 16 Pro");
        System.out.println("Pay: 150000 to buy IPhone 16 Pro Max");
    }
}

class SamsungMobile implements Product {
    public void showproduct() {
        System.out.println("Samsung Mobile Selected");
        System.out.println("Pay: 50000 to buy S25");
        System.out.println("Pay: 100000 to buy S25 FE");
        System.out.println("Pay: 150000 to buy S25 Ultra");
    }
}

class OppoMobile implements Product {
    public void showproduct() {
        System.out.println("Oppo Mobile Selected");
        System.out.println("Pay: 50000 to buy F15");
        System.out.println("Pay: 100000 to buy F15 Pro");
        System.out.println("Pay: 150000 to buy F15 Plus");
    }
}


// ABSTRACT FACTORY

abstract class ProductFactory {
    abstract Product getProduct(int choice);
}

// Clothing Factory
class ClothingFactory extends ProductFactory {
    Product getProduct(int choice) {
        if (choice == 1) return new MenClothing();
        else if (choice == 2) return new WomenClothing();
        else if (choice == 3) return new KidsClothing();
        return null;
    }
}

// Furniture Factory
class FurnitureFactory extends ProductFactory {
    Product getProduct(int choice) {
        if (choice == 1) return new WoodenFurniture();
        else if (choice == 2) return new PlasticFurniture();
        else if (choice == 3) return new GlassFurniture();
        return null;
    }
}

// Mobile Factory
class MobileFactory extends ProductFactory {
    Product getProduct(int choice) {
        if (choice == 1) return new AppleMobile();
        else if (choice == 2) return new SamsungMobile();
        else if (choice == 3) return new OppoMobile();
        return null;
    }
}

// Factory Producer
class FactoryProducer {
    static ProductFactory getFactory(int choice) {
        if (choice == 1) return new ClothingFactory();
        else if (choice == 2) return new FurnitureFactory();
        else if (choice == 3) return new MobileFactory();
        return null;
    }
}

// ======================================================= STRATEGY PATTERN (PAYMENT) ====================================================================

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy strategy;

    void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void checkout(int amount) {
        strategy.pay(amount);
    }
}

// ================================================= COMMAND PATTERN (PLACE OR CANCEL ORDER) ====================================================================

// Command Interface
interface Command {
    void execute();
}

class Order {
    void placeOrder() {
        System.out.println("\nOrder Placed Successfully!");
    }

    void cancelOrder() {
        System.out.println("\nOrder Cancelled! Deducted Money Will be refunded back shortly");
    }
}

// Concrete Command - Place Order
class PlaceOrderCommand implements Command {
    Order ord; 

    PlaceOrderCommand(Order ord) {
        this.ord = ord;
    }

    public void execute() {
        ord.placeOrder();
    }
}

// Concrete Command - Cancel Order
class CancelOrderCommand implements Command {
    Order ord; 

    CancelOrderCommand(Order ord) {
        this.ord = ord;
    }

    public void execute() {
        ord.cancelOrder();
    }
}

// Invoker
class OrderInvoker {
    Command cd;

    void setCommand(Command cd) {
        this.cd = cd;
    }

    void run() {
        cd.execute();
    }
}

// ================================================= OBSERVER PATTERN (USER AND ADMIN) ====================================================================

// OBSERVER INTERFACE
interface Observer {
    void update(String message);
}

// USER OBSERVER
class UserObserver implements Observer {
    public void update(String message) {
        System.out.println("\n==========[USER NOTIFICATION]==========");
        System.out.println(message);
    }
}

// ADMIN OBSERVER
class AdminObserver implements Observer {
    public void update(String message) {
        System.out.println("\n==========[ADMIN NOTIFICATION]==========");
        System.out.println(message);
    }
}

// SUBJECT
class OrderNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void notifyUser(String message) {
        for (Observer obs : observers) {
            if (obs instanceof UserObserver) {
                obs.update(message);
            }
        }
    }

    public void notifyAdmin(String message) {
        for (Observer obs : observers) {
            if (obs instanceof AdminObserver) {
                obs.update(message);
            }
        }
    }
}

// ======================================================== MAIN CLASS ====================================================================

public class Project {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // CATEGORY SELECTION 
        System.out.println("Choose Product Category:");
        System.out.println("1. Clothing");
        System.out.println("2. Furniture");
        System.out.println("3. Mobile");

        int category = sc.nextInt();

        ProductFactory factory = FactoryProducer.getFactory(category);

        if (factory == null) {
            System.out.println("Invalid Category!");
            return;
        }

        // PRODUCT SELECTION 
        System.out.println("Choose Product:");

        if (category == 1) {
            System.out.println("1. Men  2. Women  3. Kids");
        } else if (category == 2) {
            System.out.println("1. Wooden  2. Plastic  3. Glass");
        } else if (category == 3) {
            System.out.println("1. Apple  2. Samsung  3. Oppo");
        }

        int productChoice = sc.nextInt();

        Product product = factory.getProduct(productChoice);

        if (product != null) {
            product.showproduct();
        } else {
            System.out.println("Invalid Product!");
            return;
        }

        // PAYMENT 
        ShoppingCart cart = new ShoppingCart();

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");

        int paymentMode = sc.nextInt();
        int amount;

        if (paymentMode == 1) {
            cart.setStrategy(new CreditCardPayment());

            System.out.print("Enter CVV: ");
            sc.nextInt();

            System.out.print("Enter OTP: ");
            sc.nextInt();

        } else if (paymentMode == 2) {
            cart.setStrategy(new UpiPayment());
            sc.nextLine();

            System.out.print("Enter UPI ID: ");
            sc.nextLine();

            System.out.print("Enter Password: ");
            sc.nextLine();

        } else {
            System.out.println("Invalid Payment Option!");
            return;
        }

        System.out.print("Enter Amount: ");
        amount = sc.nextInt();

        cart.checkout(amount);

        //ORDER
        Order ord = new Order();
        OrderInvoker invoker = new OrderInvoker();

        System.out.println("1. Place Order");
        System.out.println("2. Cancel Order");
        
        int ch = sc.nextInt();
        
        if (ch == 1) {
            invoker.setCommand(new PlaceOrderCommand(ord));
            invoker.run();

            OrderNotifier notifier = new OrderNotifier();
            notifier.addObserver(new UserObserver());
            notifier.addObserver(new AdminObserver());

            int orderId = new Random().nextInt(9000000) + 1000000;

            // USER MESSAGE
            notifier.notifyUser("Thank you for placing your order!\n" +
            "Your Order ID is: " + orderId + "\n" +
            "Track here: www.shop.com/track/" + orderId);

            // ADMIN MESSAGE
            notifier.notifyAdmin("New order placed by customer.\n" +
            "Order ID: " + orderId + "\n" +
            "Track payment: www.admin.com/payment/" + orderId);
        } 

        else if (ch == 2) {
            invoker.setCommand(new CancelOrderCommand(ord));
            invoker.run();

            OrderNotifier notifier = new OrderNotifier();
            notifier.addObserver(new UserObserver());
            notifier.addObserver(new AdminObserver());

            int orderId = new Random().nextInt(9000000) + 1000000;

            // USER MESSAGE
            notifier.notifyUser("Oops! You were just one step away from placing your order.\n" +
            "Try again soon!");
            
            // ADMIN MESSAGE
            notifier.notifyAdmin("Order ID " + orderId + " is cancelled.\n" +
            "Refund is in progress.");
        } 
        else {
            System.out.println("Invalid Choice");
            return;
        }

        sc.close();
    }
}