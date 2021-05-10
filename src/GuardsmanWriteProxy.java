import utility.collection.ArrayList;

public class GuardsmanWriteProxy implements TreasuryWrite{
    private TreasureRoom treasureRoom;
    private boolean hasAccess;

    public GuardsmanWriteProxy(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
        hasAccess = true;
    }

    @Override
    public Valuable take() {
        if(hasAccess)
        {
            return treasureRoom.take();
        }
        else throw new IllegalStateException("No access.");
    }

    @Override
    public void put(Valuable valuable) {
        if(hasAccess)
        {
            treasureRoom.put(valuable);
        }
        else throw new IllegalStateException("No access.");
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
