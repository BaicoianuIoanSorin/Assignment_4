import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Miner implements Runnable { //singleton

        private Mine mine;
        private Deposit deposit;

        public Miner(Mine mine,Deposit deposit)
        {
            this.mine = mine;
            this.deposit = deposit;
        }
        public void run()
        {
            while(true)
            {
                deposit.put(mine.mine());
                try
                {
                    spendSomeTime("Resting");
                }
                catch (InterruptedException e)
                {
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
