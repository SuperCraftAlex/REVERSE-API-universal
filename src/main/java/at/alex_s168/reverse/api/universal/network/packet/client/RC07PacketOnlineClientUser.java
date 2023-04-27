package at.alex_s168.reverse.api.universal.network.packet.client;

// sent by MC client
public class RC07PacketOnlineClientUser implements Packet
{
    public String client;
    public String launchToken;

    public RC06PacketSessionEnd() {}

    public RC06PacketSessionEnd(String client, String launchToken) {
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