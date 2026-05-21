// Duck interface
interface Duck {
    void quack();
}

// Concrete class
class MallardDuck implements Duck {
    public void quack() {
        System.out.println("Quack");
    }
}

// Decorator class
class DuckDecorator implements Duck {
    protected Duck duck;

    public DuckDecorator(Duck duck) {
        this.duck = duck;
    }

    public void quack() {
        duck.quack();
    }
}

// QuackCounter Decorator
class QuackCounter extends DuckDecorator {
    private static int count = 0;

    public QuackCounter(Duck duck) {
        super(duck);
    }

    public void quack() {
        duck.quack();
        count++;
    }

    public static int getCount() {
        return count;
    }
}

// Main class
public class CompoundPattern {
    public static void main(String[] args) {

        Duck duck = new QuackCounter(new MallardDuck());

        duck.quack();
        duck.quack();

        System.out.println("Total Quacks: " + QuackCounter.getCount());
    }
}