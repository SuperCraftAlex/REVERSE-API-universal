package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.ClientUserSP;
import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC0EPacketChangeUserInfo implements RPacket
{
    public ClientUserSP user;
    public String sid;

    public RC0EPacketChangeUserInfo() {}

    public RC0EPacketChangeUserInfo(String sid, ClientUserSP user) {
        this.user = user;
        this.sid = sid;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.user = (ClientUserSP) new ClientUserSP().readData(buf);
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        this.user.writeData(buf);
        buf.writeString(sid);
    }

}