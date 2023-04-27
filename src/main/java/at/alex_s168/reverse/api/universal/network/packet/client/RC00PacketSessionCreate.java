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

    public RC00PacketSessionCreate() {}

    public RC00PacketSessionCreate(int launcherID, String userToken, String hwid) {
        this.launcherID = launcherID;
        this.userToken = userToken;
        this.hwid = hwid;
        this.protocolVersion = DEF.PROTOCOL_VERSION;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.launcherID = buf.readVarInt();
        this.userToken = buf.readString(DEF.USERTOKEN_LENGTH);
        this.hwid = buf.readString(DEF.HWID_LENGTH);
        this.protocolVersion = buf.readVarInt();
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeVarInt(this.launcherID);
        buf.writeString(this.userToken);
        buf.writeString(this.hwid);
        buf.writeVarInt(this.protocolVersion);
    }

}