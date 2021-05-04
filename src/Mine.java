import java.util.ArrayList;

public class Mine {

    private final static ArrayList<String> minerals = new ArrayList<>();

    public Mine() {
        minerals.add("Diamond");
        minerals.add("Gold nugget");
        minerals.add("Jewel");
        minerals.add("Ruby");
        minerals.add("Wooden coin");
    }

    public synchronized String mine(){
        double random = Math.random()*10;
        int randomInt = (int) random;
        return minerals.get(randomInt);
    }
}
