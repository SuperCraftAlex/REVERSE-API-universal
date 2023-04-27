package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RC07PacketOnlineClientUser implements Packet
{
    public String client;
    public String launchToken;

    public RC07PacketOnlineClientUser() {}

    public RC07PacketOnlineClientUser(String client, String launchToken) {
        this.client = client;
        this.launchToken = launchToken;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.client = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeString(this.client);
        buf.writeString(this.launchToken);
    }

}