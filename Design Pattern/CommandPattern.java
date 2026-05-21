import java.util.Scanner;

// Command Interface
interface Command {
    void execute();
}

// Receiver
class VLCPlayer {
    void play() {
        System.out.println("VLC Player is Playing");
    }

    void stop() {
        System.out.println("VLC Player is Stopped");
    }
}

// Play Command
class PlayCommand implements Command {

    VLCPlayer player;

    PlayCommand(VLCPlayer player) {
        this.player = player;
    }

    public void execute() {
        player.play();
    }
}

// Stop Command
class StopCommand implements Command {

    VLCPlayer player;

    StopCommand(VLCPlayer player) {
        this.player = player;
    }

    public void execute() {
        player.stop();
    }
}

// Invoker
class Remote {

    Command command;

    void setCommand(Command c) {
        command = c;
    }

    void press() {
        command.execute();
    }
}

// Main Class
public class CommandPattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VLCPlayer player = new VLCPlayer();
        Remote remote = new Remote();

        Command play = new PlayCommand(player);
        Command stop = new StopCommand(player);

        System.out.println("Enter 1 to Play VLC");
        System.out.println("Enter 2 to Stop VLC");

        int choice = sc.nextInt();

        if (choice == 1) {
            remote.setCommand(play);
        } else if (choice == 2) {
            remote.setCommand(stop);
        } else {
            System.out.println("Invalid Choice");
            return;
        }

        remote.press();
    }
}