import utility.collection.ArrayList;

public interface TreasuryRead
{
    ArrayList<Valuable> getInventory();
    Valuable take();
    void put(Valuable valuable);
}
