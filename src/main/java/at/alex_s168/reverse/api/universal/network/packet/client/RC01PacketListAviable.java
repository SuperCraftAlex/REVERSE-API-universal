package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC01PacketListAviable implements RPacket
{
    public String sid;

    public RC01PacketListAviable() {}

    public RC01PacketListAviable(String sid) {
        this.sid = sid;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
    }

}