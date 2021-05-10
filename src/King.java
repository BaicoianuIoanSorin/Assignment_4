import utility.collection.ArrayList;

import java.util.Random;

public class King implements Runnable{
    private TreasureRoomDoor treasureRoomDoor;
    private ArrayList<Valuable> valuable;


    public King(TreasureRoomDoor treasureRoomDoor)
    {
        this.treasureRoomDoor = treasureRoomDoor;
        valuable = new ArrayList<>();
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {

            }
            int payment = (int) (Math.random()*(150 - 50) + 50);
            TreasuryWrite treasuryWrite = treasureRoomDoor.acquireWrite();
            this.valuable = treasuryWrite.getInventory();
            while(payment > 0)
            {
                if(valuable.size() == 0)
                {
                    for(int i = 0; i < valuable.size(); i++)
                    {
                        treasuryWrite.put(valuable.get(i));
                    }
                    Log.getInstance().addLog("Party can't start. Payment has not fulfilled.");
                    break;
                }
                valuable.add(treasuryWrite.take());
                payment -= valuable.get(valuable.size() - 1).getValue();

            }
            if(payment <= 0)
            {
                Log.getInstance().addLog("PARTY PARTY PARTY PARTY PARTYYYYYYYYYYYYYYYYYYYYYYYY");
            }
            treasureRoomDoor.releaseWrite();
        }
    }
}
