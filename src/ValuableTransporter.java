import static java.lang.Thread.sleep;

public class ValuableTransporter implements Runnable{ //singleton

    private Deposit deposit;

    public ValuableTransporter(Deposit deposit){
        this.deposit = deposit;
    }



    @Override
    public void run() {
        while (true){
            deposit.take();
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
