package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC00PacketSessionCreate implements RPacket
{
    public int launcherID;
    public String userToken;
    public String hwid;
    public int protocolVersion;
    public String username;
    public String password;

    public RC00PacketSessionCreate() {}

    public RC00PacketSessionCreate(int launcherID, String userToken, String hwid, String username, String password) {
        this.launcherID = launcherID;
        this.userToken = userToken;
        this.hwid = hwid;
        this.protocolVersion = DEF.PROTOCOL_VERSION;
        this.username = username;
        this.password = password;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.launcherID = buf.readVarInt();
        this.userToken = buf.readString(DEF.USERTOKEN_LENGTH);
        this.hwid = buf.readString(DEF.HWID_LENGTH);
        this.protocolVersion = buf.readVarInt();
        this.username = buf.readString(DEF.USERNAME_LENGTH);
        this.password = buf.readString(DEF.PASSWORD_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeVarInt(this.launcherID);
        buf.writeString(this.userToken);
        buf.writeString(this.hwid);
        buf.writeVarInt(this.protocolVersion);
        buf.writeString(this.username);
        buf.writeString(this.password);
    }

}