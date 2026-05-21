import java.util.*;

public class IteratorPattern {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}