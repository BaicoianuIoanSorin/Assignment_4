import utility.collection.ArrayList;

public class GuardsmanReadProxy implements TreasuryRead{
    private TreasureRoom treasureRoom;
    private boolean hasAccess;

    public GuardsmanReadProxy(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
        hasAccess = true;
    }

    @Override
    public ArrayList<Valuable> getInventory() {
        if(hasAccess)
        {
            return treasureRoom.getInventory();
        }
        else throw new IllegalStateException("No access.");
    }

    public void restrictAccess()
    {
        hasAccess = false;
    }
}
