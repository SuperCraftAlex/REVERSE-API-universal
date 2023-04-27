package at.alex_s168.reverse.api.universal.network.packet.client;

public class RC00PacketSessionCreate implements Packet
{
    public int launcherID;
    public String userToken;
    public String hwid;

    public RC00PacketSessionCreate() {}

    public RC00PacketSessionCreate(int launcherID, String userToken, String hwid) {
        this.launcherID = launcherID;
        this.userToken = userToken;
        this.hwid = hwid;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.launcherID = buf.readVarInt();
        this.userToken = buf.readVarString();
        this.hwid = buf.readVarString();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarInt(this.launcherID);
        buf.writeVarString(this.userToken);
        buf.writeVarString(this.hwid);
    }

}