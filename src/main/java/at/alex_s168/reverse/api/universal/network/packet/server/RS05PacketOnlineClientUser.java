package at.alex_s168.reverse.api.universal.network.packet.server;

import java.util.List;

import at.alex_s168.reverse.api.universal.ClientUser;

public class RS05PacketOnlineClientUser implements Packet
{
    public List<ClientUser> users;

    public RS05PacketOnlineClientUser() {}

    public RS05PacketOnlineClientUser(String sid) {
        this.sid = sid;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readVarString();
        this.users = (List<ClientUser>) buf.readVarList();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.sid);
        buf.writeVarList(users);
    }

}