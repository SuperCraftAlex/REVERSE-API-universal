package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

// returned by server after RC05 or RC0D
public class RS04PacketSessionInfo implements RPacket
{
    public int expirationDate;

    public RS04PacketSessionInfo() {}

    public RS04PacketSessionInfo(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.expirationDate = buf.readVarInt();
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeVarInt(this.expirationDate);
    }

}