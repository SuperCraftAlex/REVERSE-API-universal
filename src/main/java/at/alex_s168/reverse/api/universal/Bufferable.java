package at.alex_s168.reverse.api.universal;

public interface Bufferable {
    
    void readData(PacketBuffer buf);
    void writeData(PacketBuffer buf);

}