package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.Downloadable;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC09PacketRequestDownloadA implements RPacket
{
    public String sid;
    public Downloadable element;

    public RC09PacketRequestDownloadA() {}

    public RC09PacketRequestDownloadA(String sid, Downloadable element) {
        this.sid = sid;
        this.element = element;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.element = new Downloadable().readData(buf);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        this.element.writeData(buf);
    }

}