package at.alex_s168.reverse.api.universal.network.packet.server;

import java.util.List;

import at.alex_s168.reverse.api.universal.ClientUser;
import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RS05PacketOnlineClientUser implements Packet
{
    public List<ClientUser> users;
    public String launchToken;

    public RS05PacketOnlineClientUser() {}

    public RS05PacketOnlineClientUser(String launchToken) {
        this.launchToken = launchToken;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
        this.users = (List<ClientUser>) buf.readList(ClientUser.class);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeString(this.launchToken);
        buf.writeList(users);
    }

}