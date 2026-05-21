// SUBSYSTEM CLASSES
class CPU {
    void start() {
        System.out.println("\nYour Computer's CPU has started");
    }
}

class Memory {
    void load() {
        System.out.println("\nMemory is also loaded");
    }
}

class HardDrive {
    void read() {
        System.out.println("\nHard Drive is reading the data\n");
    }
}

// FACADE CLASS
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hd;

    ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hd = new HardDrive();
    }

    void startComputer() {
        cpu.start();
        memory.load();
        hd.read();
    }
}

// MAIN CLASS
public class FacadePattern {
    public static void main(String[] args) {

        ComputerFacade computer = new ComputerFacade();

        computer.startComputer(); // single call
    }
}
