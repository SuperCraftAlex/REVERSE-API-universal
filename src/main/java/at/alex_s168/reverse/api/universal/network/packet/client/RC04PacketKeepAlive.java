package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RC04PacketKeepAlive implements Packet
{
    public int launcherID;
    public String userToken;
    public String hwid;
    public String sid;

    public RC04PacketKeepAlive() {}

    public RC04PacketKeepAlive(String sid, int launcherID, String userToken, String hwid) {
        this.sid = sid;
        this.launcherID = launcherID;
        this.userToken = userToken;
        this.hwid = hwid;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.launcherID = buf.readVarInt();
        this.userToken = buf.readString(DEF.USERTOKEN_LENGTH);
        this.hwid = buf.readString(DEF.HWID_LENGTH);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        buf.writeVarInt(this.launcherID);
        buf.writeString(this.userToken);
        buf.writeString(this.hwid);
    }

}