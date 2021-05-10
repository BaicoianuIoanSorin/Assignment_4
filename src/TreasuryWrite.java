public interface TreasuryWrite extends TreasuryRead{
    Valuable take();
    void put(Valuable valuable);
}
