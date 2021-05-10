public interface TreasureRoomDoor {
    TreasuryRead acquireRead();
    void releaseRead();
    TreasuryWrite acquireWrite();
    void releaseWrite();
}
