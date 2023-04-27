package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC0DPacketSessionInfoB implements RPacket
{
    public String launchToken;

    public RC0DPacketSessionInfoB() {}

    public RC0DPacketSessionInfoB(String launchToken) {
        this.launchToken = launchToken;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.launchToken);
    }

}