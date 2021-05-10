import utility.collection.ArrayList;

public class TreasureRoom implements TreasuryWrite {
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
    public Valuable take() {
        return valuables.remove(0);
    }

    @Override
    public void put(Valuable valuable) {
        valuables.add(valuable);
    }
}
