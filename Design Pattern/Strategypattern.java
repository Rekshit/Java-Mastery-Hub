import java.util.Scanner;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Upi.");
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Set the strategy
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Strategy Pattern
public class Strategypattern {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Enter Payment Type: 1.Credit Card   2.UPI ");
        int mode = sc.nextInt();

        int amount;

        if (mode == 1) {
            cart.setPaymentStrategy(new CreditCardPayment());

            System.out.print("Enter CVV: ");
            int cvv = sc.nextInt();

            System.out.print("Enter 6 digit OTP: ");
            int otp = sc.nextInt();

            System.out.print("Enter amount: ");
            amount = sc.nextInt();

        } 
        else if (mode == 2) {
            cart.setPaymentStrategy(new UpiPayment());
            sc.nextLine(); 

            System.out.print("Enter UPI ID: ");
            String upiId = sc.nextLine();

            System.out.print("Enter 6 digit password: ");
            String password = sc.nextLine();

            System.out.print("Enter amount: ");
            amount = sc.nextInt();

        } 
        else {
            System.out.println("Invalid payment option.");
            return;
        }

        cart.checkout(amount);
        sc.close();
    }
}
