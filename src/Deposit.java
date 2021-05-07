import utility.collection.ArrayList;
import utility.collection.ListADT;

public class Deposit {
    private ListADT<Valuable> storedValuables;

    public Deposit(){
        storedValuables = new ArrayList<>();
    }

    public synchronized void put(Valuable valuable){
        storedValuables.add(valuable);
        Log.getInstance().addLog(Thread.currentThread().getName() + ": " + valuable + " added.");
        notifyAll();

    }

    public synchronized ArrayList<Valuable> take(){
        int value = 0;
        ArrayList<Valuable> dummyArray = new ArrayList<>();
        while(getWorth() < 50){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (storedValuables.size()>0 && value <= 200){
            dummyArray.add(storedValuables.get(0));
            value += storedValuables.get(0).getValue();
            storedValuables.remove(0);
        }
        Log.getInstance().addLog(Thread.currentThread().getName() + ": valuables have been taken.");
        notifyAll();
        return dummyArray;
    }

    public int getWorth()
    {
        int value = 0;
        for(int i = 0; i < storedValuables.size(); i++)
        {
            value += storedValuables.get(i).getValue();
        }
        return value;
    }

    public ListADT<Valuable> getStoredValuables() {
        return storedValuables;
    }
}
