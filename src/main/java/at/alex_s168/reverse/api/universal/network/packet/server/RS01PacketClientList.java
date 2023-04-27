package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS01PacketClientList implements RPacket
{
    public String[] owned;
    public String[] visible;

    public RS01PacketClientList() {}

    public RS01PacketClientList(String[] clients, String[] visible) {
        this.owned = clients;
        this.visible = visible;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.owned = buf.readStringArray(100);
        this.visible = buf.readStringArray(100);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeStringArray(this.owned);
        buf.writeStringArray(this.visible);
    }

}