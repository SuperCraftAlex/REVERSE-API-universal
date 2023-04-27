package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.ClientUser;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;
import java.util.List;

public class RS0DPacketFriendList implements RPacket
{
    public List<ClientUser> users;

    public RS0DPacketFriendList() {}

    public RS0DPacketFriendList(List<ClientUser> users) {
        this.users = users;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.users = (List<ClientUser>) buf.readList(ClientUser.class);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeList(users);
    }

}