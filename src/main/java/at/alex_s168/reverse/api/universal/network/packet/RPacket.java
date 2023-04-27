package at.alex_s168.reverse.api.universal.network.packet;

import at.alex_s168.reverse.api.universal.network.RPacketBuffer;

import java.io.IOException;

public interface RPacket
{
    /**
     * Reads the raw packet data from the data stream.
     */
    void readPacketData(RPacketBuffer buf) throws IOException;

    /**
     * Writes the raw packet data to the data stream.
     */
    void writePacketData(RPacketBuffer buf) throws IOException;
}