package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS0CPacketServerInfo implements RPacket
{
    public Result result;

    public RS0CPacketServerInfo() {}

    public RS0CPacketServerInfo(Result result) {
        this.result = result;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.result = buf.readEnumValue(Result.class);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeEnumValue(this.result);
    }

    public enum Result {
        USABLE,
        USE_OTHER,
        ERROR
    }

}