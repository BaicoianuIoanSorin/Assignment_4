public interface TreasureRoomDoor {
    TreasuryRead acquireRead();
    void releaseRead();
    TreasuryRead acquireWrite();
    void releaseWrite();
}
