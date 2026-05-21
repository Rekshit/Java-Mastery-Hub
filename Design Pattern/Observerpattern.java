import java.util.ArrayList;

// Observer Interface 
interface Subscriber {
    void update(String videoTitle);
}

// Concrete Observer 
class User implements Subscriber {
    String name;

    User(String name) {
        this.name = name;
    }

    public void update(String videoTitle) {
        System.out.println(name + " received notification: New video -> " + videoTitle);
    }
}

// Subject Interface 
interface Channel {
    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void notifySubscribers(String videoTitle);
}

// Concrete Subject 
class YouTubeChannel implements Channel {
    ArrayList<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers(String videoTitle) {
        for (Subscriber s : subscribers) {
            s.update(videoTitle);
        }
    }

    void uploadVideo(String title) {
        System.out.println("\nChannel uploaded video: " + title);
        notifySubscribers(title);
    }
}

// Main Class 
public class Observerpattern {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Subscriber s1 = new User("Amit");
        Subscriber s2 = new User("Riya");
        Subscriber s3 = new User("John");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);

        channel.uploadVideo("Vlog-1 Welcome of guests");

        channel.unsubscribe(s2);

        channel.uploadVideo("Vlog-2 Dinner with guests");
    }
}
