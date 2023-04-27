package at.alex_s168.reverse.api.universal.network.packet.client;

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
        this.sid = buf.readVarString();
        this.launcherID = buf.readVarInt();
        this.userToken = buf.readVarString();
        this.hwid = buf.readVarString();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.sid);
        buf.writeVarInt(this.launcherID);
        buf.writeVarString(this.userToken);
        buf.writeVarString(this.hwid);
    }

}