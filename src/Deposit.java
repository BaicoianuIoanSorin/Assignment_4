import java.util.ArrayList;

public class Deposit {
    private ArrayList<String> storedValuables;

    public Deposit(){
        storedValuables = new ArrayList<>();
    }

    public synchronized void put(String valuable){
        storedValuables.add(valuable);
        System.out.println(valuable + " added");
    }

    public synchronized ArrayList<String> take(){
        ArrayList<String> dummyArray = new ArrayList<>();
        while(storedValuables.size()<50){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (storedValuables.size()>0 && dummyArray.size()<=200){
            dummyArray.add(storedValuables.get(0));
            storedValuables.remove(0);
        }
        notifyAll();
        return dummyArray;
    }
}
