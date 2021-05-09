public class Guardsman implements TreasureRoomDoor{
    private int kings;
    private int accountants;
    private int waitingAccountants;
    private TreasureRoom treasureRoom;

    public Guardsman()
    {
        kings = 0;
        accountants = 0;
        waitingAccountants = 0;
        treasureRoom = new TreasureRoom();
    }

    @Override
    public TreasuryRead acquireRead() {
        while(kings > 0)
        {
            try {
                Log.getInstance().addLog(Thread.currentThread().getName() + " WAIT: Accountants > " + accountants + ", waiting accountants > " + waitingAccountants);
                wait();
            }
        }
        kings++;
        Log.getInstance().addLog(Thread.currentThread().getName() + " ";
        /**think tomorrow at this part**/
    }

    @Override
    public void releaseRead() {

    }

    @Override
    public TreasuryRead acquireWrite() {
        return null;
    }

    @Override
    public void releaseWrite() {

    }
}
