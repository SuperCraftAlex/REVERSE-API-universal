package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RC06PacketSessionEnd implements Packet
{
    public String sid;

    public RC06PacketSessionEnd() {}

    public RC06PacketSessionEnd(String sid) {
        this.sid = sid;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
    }

}