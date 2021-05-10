public class Accountant implements Runnable{

    private final TreasureRoomDoor treasureRoomDoor;
    private final static int time = 2000;
    private int value;

    public Accountant(TreasureRoomDoor treasureRoomDoor)
    {
        this.treasureRoomDoor = treasureRoomDoor;
        value = 0;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Log.getInstance().addLog(Thread.currentThread().getName() + " is waiting for counting.");
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            TreasuryRead treasuryRead = treasureRoomDoor.acquireRead();
            for(int i = 0; i < treasuryRead.getInventory().size(); i++)
            {
                value += treasuryRead.getInventory().get(i).getValue();
            }
            treasureRoomDoor.releaseRead();
            Log.getInstance().addLog("Value: " + value);
        }
    }



}
