// Component Interface
interface Pizza {
    String getDescription();
    int getCost();
}

// Concrete Component
class PlainPizza implements Pizza {
    public String getDescription() {
        return "Plain Pizza";
    }

    public int getCost() {
        return 100;
    }
}

// Decorator Abstract Class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete Decorators
class Cheese extends PizzaDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public int getCost() {
        return pizza.getCost() + 20;
    }
}

class Mushroom extends PizzaDecorator {

    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    public int getCost() {
        return pizza.getCost() + 30;
    }
}

// Main Class
public class decorator {
    public static void main(String[] args) {

        Pizza pizza = new PlainPizza();
        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());
        System.out.println("\n");

        pizza = new Cheese(pizza);
        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());
        System.out.println("\n");

        pizza = new Mushroom(pizza);
        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Total Cost: " + pizza.getCost());
    }
}
