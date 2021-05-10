import utility.collection.ArrayList;

import static java.lang.Thread.sleep;

public class ValuableTransporter implements Runnable{ //singleton

    private Deposit deposit;
    private TreasureRoom treasureRoom;

    public ValuableTransporter(Deposit deposit, TreasureRoom treasureRoom){
        this.deposit = deposit;
        this.treasureRoom = treasureRoom;
    }



    @Override
    public void run() {
        while (true){
            ArrayList<Valuable> valuables = deposit.take();
            for(int i = 0; i < valuables.size(); i++)
            {
                treasureRoom.put(valuables.get(i));
            }
            try {
                spendSomeTime("Delivering goods");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void spendSomeTime(String what) throws InterruptedException
    {
        sleep(1000);
        System.out.println(what);
    }

}
