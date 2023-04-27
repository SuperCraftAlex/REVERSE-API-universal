package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS0EPacketFriendActionResult implements RPacket
{
    public Result result;
    public String username;

    public RS0EPacketFriendActionResult() {}

    public RS0EPacketFriendActionResult(Result result, String username) {
        this.result = result;
        this.username = username;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.result = buf.readEnumValue(Result.class);
        this.username = buf.readString(DEF.USERNAME_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeEnumValue(this.result);
        buf.writeString(username);
    }

    public enum Result {
        SUCCES,
        INVALID_USER,
        INVALID_TOKEN,
        INTERNAL_ERROR
    }

}