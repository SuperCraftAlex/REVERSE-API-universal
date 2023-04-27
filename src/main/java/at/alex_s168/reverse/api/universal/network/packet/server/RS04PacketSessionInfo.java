package at.alex_s168.reverse.api.universal.network.packet.server;

// returned by server after RC05

public class RS04PacketSessionInfo implements Packet
{
    public String sid;
    public int expirationDate;

    public RS04PacketSessionInfo() {}

    public RS04PacketSessionInfo(String sid, int expirationDate) {
        this.sid = sid;
        this.expirationDate = expirationDate;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readVarString();
        this.expirationDate = buf.readVarInt();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.sid);
        buf.writeVarInt(this.expirationDate);
    }

}