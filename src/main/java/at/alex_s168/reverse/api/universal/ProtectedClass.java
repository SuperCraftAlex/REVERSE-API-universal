package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.Bufferable;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;

import java.io.IOException;

public class ProtectedClass implements Bufferable<ProtectedClass> {

    public byte[] bytes;
    public String name;
    public String location;

    public ProtectedClass(byte[] bytes, String name, String location) {
        this.bytes = bytes;
        this.name = name;
        this.location = location;
    }

    @Override
    public ProtectedClass readData(RPacketBuffer buf) throws IOException {
        this.bytes = buf.readByteArray();
        this.name = buf.readString(64);
        this.location = buf.readString(buf.readableBytes());
        return this;
    }

    @Override
    public void writeData(RPacketBuffer buf) throws IOException {
        buf.writeByteArray(this.bytes);
        buf.writeString(this.name);
        buf.writeString(this.location);
    }
}
