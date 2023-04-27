package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC0FPacketRequestServerInfo implements RPacket
{
    public String launcherToken;

    public RC0FPacketRequestServerInfo() {}

    public RC0FPacketRequestServerInfo(String launcherToken) {
        this.launcherToken = launcherToken;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.launcherToken = buf.readString(DEF.SESSIONID_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.launcherToken);
    }

}