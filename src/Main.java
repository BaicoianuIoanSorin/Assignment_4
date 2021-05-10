public class Main {
    public static void main(String[] args) {
        Deposit deposit = new Deposit();
        Mine mine = new Mine();
        TreasureRoom treasureRoom = new TreasureRoom();


        Miner miner1 = new Miner(mine,deposit);
        Miner miner2 = new Miner(mine,deposit);
        Miner miner3 = new Miner(mine,deposit);

        ValuableTransporter valuableTransporter1 = new ValuableTransporter(deposit,treasureRoom);
        ValuableTransporter valuableTransporter2 = new ValuableTransporter(deposit,treasureRoom);


        Guardsman guardsman = new Guardsman(treasureRoom);

        Accountant accountant1 = new Accountant(guardsman);
        Accountant accountant2 = new Accountant(guardsman);
        Accountant accountant3 = new Accountant(guardsman);

        King king = new King(guardsman);

        (new Thread(miner1, "Miner1")).start();
        (new Thread(miner2, "Miner2")).start();
        (new Thread(miner3, "Miner3")).start();
        (new Thread(valuableTransporter1, "Valuable Transporter1")).start();
        (new Thread(valuableTransporter2, "Valuable Transporter2")).start();
        (new Thread(accountant1,"Accountant1")).start();
        (new Thread(accountant2,"Accountant2")).start();
        (new Thread(accountant3,"Accountant3")).start();
        (new Thread(king,"King")).start();
     }
}
