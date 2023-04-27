package at.alex_s168.reverse.api.universal.network.packet.client;

public class RC05PacketSessionInfo implements Packet
{
    public String sid;

    public RC05PacketSessionInfo() {}

    public RC05PacketSessionInfo(String sid) {
        this.sid = sid;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readVarString();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.sid);
    }

}