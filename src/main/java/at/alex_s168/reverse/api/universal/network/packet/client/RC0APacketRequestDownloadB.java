package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.Downloadable;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC0APacketRequestDownloadB implements RPacket
{
    public String launchToken;
    public Downloadable element;

    public RC0APacketRequestDownloadB() {}

    public RC0APacketRequestDownloadB(String launchToken, Downloadable element) {
        this.launchToken = launchToken;
        this.element = element;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
        this.element = new Downloadable().readData(buf);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.launchToken);
        this.element.writeData(buf);
    }

}