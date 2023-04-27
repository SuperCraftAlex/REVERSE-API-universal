package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.Bufferable;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;

import java.io.IOException;

public class ClientLicense implements Bufferable<ClientLicense> {

    public Type type;
    public int expires;

    @Override
    public ClientLicense readData(RPacketBuffer buf) throws IOException {
        this.type = buf.readEnumValue(Type.class);
        this.expires = buf.readVarInt();
        return this;
    }

    @Override
    public void writeData(RPacketBuffer buf) throws IOException {
        buf.writeEnumValue(this.type);
        buf.writeInt(this.expires);
    }

    public enum Type {
        EXPIRES,
        TEST,
        CONTENT,
        DEV,
        LIFETIME
    }

}
