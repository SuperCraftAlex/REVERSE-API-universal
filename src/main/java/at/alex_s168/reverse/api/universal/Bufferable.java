package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.PacketBuffer;

public interface Bufferable {
    
    Bufferable readData(PacketBuffer buf);
    void writeData(PacketBuffer buf);

}