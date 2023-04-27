package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.ClientUser;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS06PacketUserInfo implements RPacket
{
    public ClientUser user;

    public RS06PacketUserInfo() {}

    public RS06PacketUserInfo(ClientUser user) {
        this.user = user;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.user = new ClientUser().readData(buf);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        this.user.writeData(buf);
    }

}