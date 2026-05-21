// ABSTRACT CLASS
abstract class Game {

    // Abstract methods 
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Template method 
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

// CONCRETE CLASS
class Cricket extends Game {

    void initialize() {
        System.out.println("\nCricket Game Initialized");
    }

    void startPlay() {
        System.out.println("\nCricket Game Started");
    }

    void endPlay() {
        System.out.println("\nCricket Game Finished\n");
    }
}

// MAIN CLASS
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();               
    }
}