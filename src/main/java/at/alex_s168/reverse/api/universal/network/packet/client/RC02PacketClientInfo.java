package at.alex_s168.reverse.api.universal.network.packet.client;

public class RC01PacketListAviable implements Packet
{
    public String sid;
    public String client;

    public RC01PacketListAviable() {}

    public RC01PacketListAviable(String sid, String client) {
        this.sid = sid;
        this.client = client;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.sid = buf.readVarString();
        this.client = buf.readVarString();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.sid);
        buf.writeVarString(this.client);
    }

}