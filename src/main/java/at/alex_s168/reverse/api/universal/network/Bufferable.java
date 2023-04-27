package at.alex_s168.reverse.api.universal.network;

import java.io.IOException;

public interface Bufferable<T extends Bufferable<T>> {

    T readData(RPacketBuffer buf) throws IOException;
    void writeData(RPacketBuffer buf) throws IOException;

}