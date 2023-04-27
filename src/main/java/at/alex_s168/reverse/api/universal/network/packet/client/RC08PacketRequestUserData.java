package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC08PacketRequestUserData implements RPacket
{
    public String username;
    public UsernameType type;
    public String launchToken;

    public RC08PacketRequestUserData() {}

    public RC08PacketRequestUserData(String username, UsernameType type, String launchToken) {
        this.username = username;
        this.type = type;
        this.launchToken = launchToken;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.username = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.type = buf.readEnumValue(UsernameType.class);
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.username);
        buf.writeEnumValue(type);
        buf.writeString(this.launchToken);
    }

    public enum UsernameType {
        REVERSE,
        INGAME
    }

}