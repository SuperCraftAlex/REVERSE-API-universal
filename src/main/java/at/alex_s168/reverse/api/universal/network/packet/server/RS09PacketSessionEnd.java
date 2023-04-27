package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

// notifies the client that the session has ended
public class RS09PacketSessionEnd implements RPacket
{
    public String sid;

    public RS09PacketSessionEnd() {}

    public RS09PacketSessionEnd(String sid, int expirationDate) {
        this.sid = sid;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
    }

}