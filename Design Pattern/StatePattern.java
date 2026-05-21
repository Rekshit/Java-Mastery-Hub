// State interface
interface State {
    void doAction();
}

// Start State
class StartState implements State {
    public void doAction() {
        System.out.println("Player is in Start State");
    }
}

// Stop State
class StopState implements State {
    public void doAction() {
        System.out.println("Player is in Stop State");
    }
}

// Context class
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void execute() {
        state.doAction();
    }
}

// Main class
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new StartState());
        context.execute();

        context.setState(new StopState());
        context.execute();
    }
}