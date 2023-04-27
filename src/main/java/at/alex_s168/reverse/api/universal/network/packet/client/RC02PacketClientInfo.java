package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RC02PacketClientInfo implements Packet
{
    public String sid;
    public String client;

    public RC02PacketClientInfo() {}

    public RC02PacketClientInfo(String sid, String client) {
        this.sid = sid;
        this.client = client;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.client = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        buf.writeString(this.client);
    }

}