package at.alex_s168.reverse.api.universal.network.packet.server;

// returned by server after RC03

public class RS03PacketClientAuth implements Packet
{
    public String client;
    public String launchToken;

    public RS03PacketClientAuth() {}

    public RS03PacketClientAuth(String client, String launchToken) {
        this.client = client;
        this.launchToken = launchToken;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.client = buf.readVarString();
        this.launchToken = buf.readVarString();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.client);
        buf.writeVarString(this.launchToken);
    }

}