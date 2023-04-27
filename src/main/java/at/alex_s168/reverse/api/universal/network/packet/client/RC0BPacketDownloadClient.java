package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC0BPacketDownloadClient implements RPacket
{
    public String sid;
    public String client;
    public String version;

    public RC0BPacketDownloadClient() {}

    public RC0BPacketDownloadClient(String sid, String client, String version) {
        this.sid = sid;
        this.client = client;
        this.version = version;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.client = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.version = buf.readString(64);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        buf.writeString(this.client);
        buf.writeString(this.version);
    }

}