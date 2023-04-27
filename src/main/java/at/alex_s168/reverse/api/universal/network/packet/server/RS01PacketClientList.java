package at.alex_s168.reverse.api.universal.network.packet.server;

public class RS01PacketClientList implements Packet
{
    public String[] clients;

    public RS01PacketClientList() {}

    public RS01PacketClientList(String[] clients) {
        this.clients = clients;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.clients = buf.readVarStringArray();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarStringArray(this.clients);
    }

}