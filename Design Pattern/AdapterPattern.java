// OLD CLASS 
class OldPrinter {
    void printOld(String text) {
        System.out.println("\nPrinting using Old Printer: " + text);
    }
}

// NEW INTERFACE
interface Printer {
    void print(String text);
}

// ADAPTER CLASS
class PrinterAdapter implements Printer {
    OldPrinter oldPrinter;

    PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    public void print(String text) {
        oldPrinter.printOld(text);
    }
}

// MAIN CLASS
public class AdapterPattern {
    public static void main(String[] args) {

        OldPrinter oldPrinter = new OldPrinter();

        Printer printer = new PrinterAdapter(oldPrinter);

        printer.print("Hello Your Prints Are Ready\n ");
    }
}