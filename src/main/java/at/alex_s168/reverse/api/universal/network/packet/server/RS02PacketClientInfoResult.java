package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.ClientInfo;
import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS02PacketClientInfoResult implements RPacket
{
    public String name;

    public ClientInfo info;

    public RS02PacketClientInfoResult() {}

    public RS02PacketClientInfoResult(String name, ClientInfo info) {
        this.name = name;
        this.info = info;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.name = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        info = new ClientInfo().readData(buf);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.name);

        info.writeData(buf);
    }

}