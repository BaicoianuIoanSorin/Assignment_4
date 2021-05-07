import java.util.HashMap;
import java.util.Objects;

public class Valuable {
    private String name;
    private int value;
    private static HashMap<String, Valuable> valuables = new HashMap<>();

    public Valuable(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public String toString(){
        return value + " of " + name;
    }

    public static Valuable getInstance(String key)
    {
        Valuable instance = valuables.get(key);
        if(instance == null)
        {
            synchronized (valuables)
            {
                instance = valuables.get(key);
                if(instance == null)
                {
                    instance = new Valuable(key,0);
                    valuables.put(key, instance);
                }
            }
        }
        return instance;
    }
}
