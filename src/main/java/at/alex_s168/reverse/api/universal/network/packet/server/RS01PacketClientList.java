package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RS01PacketClientList implements Packet
{
    public String[] clients;

    public RS01PacketClientList() {}

    public RS01PacketClientList(String[] clients) {
        this.clients = clients;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.clients = buf.readStringArray(100);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeStringArray(this.clients);
    }

}