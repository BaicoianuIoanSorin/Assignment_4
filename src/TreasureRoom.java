import utility.collection.ArrayList;

public class TreasureRoom implements TreasuryRead {
    private ArrayList<Valuable> valuables;

    public TreasureRoom()
    {
        valuables = new ArrayList<>();
    }

    @Override
    public ArrayList<Valuable> getInventory() {
        return valuables;
    }

    @Override
    public synchronized Valuable take() {
        Valuable removedValuable = valuables.get(0);
        valuables.remove(0);
        return removedValuable;
    }

    @Override
    public synchronized void put(Valuable valuable) {
        valuables.add(valuable);
    }
}
