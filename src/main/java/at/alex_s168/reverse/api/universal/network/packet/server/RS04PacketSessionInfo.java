package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS04PacketSessionInfo implements RPacket
{
    public String sid;
    public int expirationDate;

    public RS04PacketSessionInfo() {}

    public RS04PacketSessionInfo(String sid, int expirationDate) {
        this.sid = sid;
        this.expirationDate = expirationDate;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.expirationDate = buf.readVarInt();
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        buf.writeVarInt(this.expirationDate);
    }

}