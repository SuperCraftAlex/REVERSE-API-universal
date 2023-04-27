package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.ProtectedClass;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;
import java.util.List;

public class RS08PacketClientDownloadResult implements RPacket
{
    public String artifactId;
    public Result result;
    private byte[] value;
    private List<ProtectedClass> protectedClasses;

    public RS08PacketClientDownloadResult() {}

    public RS08PacketClientDownloadResult(String artifactId, Result result, byte[] value, List<ProtectedClass> protectedClasses) {
        this.artifactId = artifactId;
        this.result = result;
        this.value = value;
        this.protectedClasses = protectedClasses;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.artifactId = buf.readString(DEF.ARTIFACT_LENGTH);
        this.result = buf.readEnumValue(Result.class);
        this.value = buf.readByteArray();
        this.protectedClasses = (List<ProtectedClass>) buf.readList(ProtectedClass.class);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.artifactId);
        buf.writeEnumValue(this.result);
        buf.writeByteArray(this.value);
        buf.writeList(protectedClasses);
    }

    public enum Result {
        SUCCES,
        NO_ACCES,
        INVALID_AUTH,
        INTERNAL_ERROR,
        NOT_FOUND
    }

}