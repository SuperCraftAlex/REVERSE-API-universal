package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS03PacketClientAuth implements RPacket
{
    public String client;
    public String launchToken;

    public RS03PacketClientAuth() {}

    public RS03PacketClientAuth(String client, String launchToken) {
        this.client = client;
        this.launchToken = launchToken;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.client = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.client);
        buf.writeString(this.launchToken);
    }

}