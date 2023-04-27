package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.ClientUser;
import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS07PacketDownloadResult implements RPacket
{
    public String artifactId;
    public Result result;
    public byte[] value;

    public RS07PacketDownloadResult() {}

    public RS07PacketDownloadResult(String artifactId, Result result, byte[] value) {
        this.artifactId = artifactId;
        this.result = result;
        this.value = value;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.artifactId = buf.readString(DEF.ARTIFACT_LENGTH);
        this.result = buf.readEnumValue(Result.class);
        this.value = buf.readByteArray();
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.artifactId);
        buf.writeEnumValue(this.result);
        buf.writeByteArray(this.value);
    }

    public enum Result {
        FILE,
        BYTE,
        NO_ACCES,
        INVALID_AUTH,
        INTERNAL_ERROR,
        NOT_FOUND
    }

}