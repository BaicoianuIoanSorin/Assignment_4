public class Main {
    public static void main(String[] args) {
        Deposit deposit = new Deposit();
        Mine mine = new Mine();

        Miner miner1 = new Miner(mine,deposit);
        Miner miner2 = new Miner(mine,deposit);
        Miner miner3 = new Miner(mine,deposit);

        ValuableTransporter valuableTransporter1 = new ValuableTransporter(deposit);
        ValuableTransporter valuableTransporter2 = new ValuableTransporter(deposit);

        (new Thread(miner1, "Miner1")).start();
        (new Thread(miner2, "Miner2")).start();
        (new Thread(miner3, "Miner3")).start();
        (new Thread(valuableTransporter1, "Valuable Transporter1")).start();
        (new Thread(valuableTransporter2, "Valuable Transporter2")).start();
     }
}
