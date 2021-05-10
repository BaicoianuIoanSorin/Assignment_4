import java.util.HashMap;
import java.util.Map;

public class Guardsman implements TreasureRoomDoor{
    private int accountants;
    private int kings;
    private int waitingKings;
    private TreasureRoom treasureRoom;
    private Map<Thread, GuardsmanReadProxy> proxiesRead;
    private Map<Thread, GuardsmanWriteProxy> proxiesWrite;

    public Guardsman(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
        accountants = 0;
        kings = 0;
        waitingKings = 0;
        proxiesRead = new HashMap<>();
        proxiesWrite = new HashMap<>();
    }
    @Override
    public synchronized TreasuryRead acquireRead() {
        while(kings > 0 || waitingKings > 0)
        {
            try {
                Log.getInstance().addLog(Thread.currentThread().getName() + " WAIT: King > " + kings + ", waiting kings > " + waitingKings);
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        accountants++;
        Log.getInstance().addLog(Thread.currentThread().getName() + " COUNTING: Kings > " + kings + ", waiting kings> " + waitingKings);

        //Proxy
        GuardsmanReadProxy guardsmanReadProxy = new GuardsmanReadProxy(treasureRoom);
        proxiesRead.put(Thread.currentThread(), guardsmanReadProxy);
        return guardsmanReadProxy;
    }

    @Override
    public synchronized void releaseRead() {
        accountants--;
        if(accountants == 0)
        {
            notifyAll();
        }

        //Proxy
        GuardsmanReadProxy guardsmanReadProxy = proxiesRead.get(Thread.currentThread());
        if(guardsmanReadProxy != null)
        {
            guardsmanReadProxy.restrictAccess();
            proxiesRead.remove(Thread.currentThread());
        }

        Log.getInstance().addLog(Thread.currentThread().getName() + " STOPPED COUNTING: Kings > " + kings + ", waiting kings > " + waitingKings);
    }

    @Override
    public synchronized TreasuryWrite acquireWrite() {
        waitingKings++;
        while(accountants > 0 || kings > 0)
        {
            try {
                Log.getInstance().addLog(Thread.currentThread().getName() + " WAITING: Accountants > " + accountants + ", kings > " + kings);
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        waitingKings--;
        kings++;
        Log.getInstance().addLog(Thread.currentThread().getName() + " is taking or putting valuables.");

        //Proxy
        GuardsmanWriteProxy guardsmanWriteProxy = new GuardsmanWriteProxy(treasureRoom);
        proxiesWrite.put(Thread.currentThread(), guardsmanWriteProxy);
        return guardsmanWriteProxy;
    }

    @Override
    public synchronized void releaseWrite() {
        kings--;
        notifyAll();
        //Proxy
        GuardsmanWriteProxy guardsmanWriteProxy = proxiesWrite.get(Thread.currentThread());
        if(guardsmanWriteProxy != null)
        {
            guardsmanWriteProxy.restrictAccess();
            proxiesWrite.remove(Thread.currentThread());
        }

        Log.getInstance().addLog(Thread.currentThread().getName() + " stopped taking or putting. Kings > " + kings);
    }
}
