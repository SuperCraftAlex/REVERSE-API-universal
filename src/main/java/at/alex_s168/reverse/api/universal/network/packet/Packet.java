package at.alex_s168.reverse.api.universal.network.packet;

import at.alex_s168.reverse.api.universal.network.PacketBuffer;

import java.io.IOException;

public interface Packet
{
    /**
     * Reads the raw packet data from the data stream.
     */
    void readPacketData(PacketBuffer buf) throws IOException;

    /**
     * Writes the raw packet data to the data stream.
     */
    void writePacketData(PacketBuffer buf) throws IOException;
}