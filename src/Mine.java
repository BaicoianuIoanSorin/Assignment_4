import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Mine {
    private ArrayList<String> minerals = new ArrayList<>();
    public Mine() {

        minerals.add("Diamond");
        minerals.add("Gold nugget");
        minerals.add("Jewel");
        minerals.add("Ruby");
        minerals.add("Wooden coin");
        Valuable.getInstance("Diamond").setValue(100);
        Valuable.getInstance("Gold nugget").setValue(80);
        Valuable.getInstance("Jewel").setValue(60);
        Valuable.getInstance("Ruby").setValue(70);
        Valuable.getInstance("Wooden coin").setValue(10);
    }
    public synchronized Valuable mine(){

        int randomInt = ThreadLocalRandom.current().nextInt(0,5);
        return Valuable.getInstance(minerals.get(randomInt));
    }
}