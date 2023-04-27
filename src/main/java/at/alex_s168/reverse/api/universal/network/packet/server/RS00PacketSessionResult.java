package at.alex_s168.reverse.api.universal.network.packet.server;

public class RS00PacketSessionResult implements Packet
{
    public String sid;

    public RS00PacketSessionResult() {}

    public RS00PacketSessionResult(String sid) {
        this.sid = sid;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readVarString();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.sid);
    }

}