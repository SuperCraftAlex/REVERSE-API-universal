package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC0CPacketRedeemClientToken implements RPacket
{
    public String sid;
    public String token;

    public RC0CPacketRedeemClientToken() {}

    public RC0CPacketRedeemClientToken(String sid, String token) {
        this.sid = sid;
        this.token = token;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.token = buf.readString(DEF.CLIENTTOKEN_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        buf.writeString(this.token);
    }

}