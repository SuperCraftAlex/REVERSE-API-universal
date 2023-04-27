package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;
import java.net.InetAddress;

public class RS00PacketSessionResult implements RPacket
{
    public String sid;
    public String username;
    public InetAddress ip;
    public Status status;

    public RS00PacketSessionResult() {}

    public RS00PacketSessionResult(String sid, String username, InetAddress ip, Status status) {
        this.sid = sid;
        this.username = username;
        this.ip = ip;
        this.status = status;
    }
    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.sid = buf.readString(DEF.SESSIONID_LENGTH);
        this.username = buf.readString(DEF.USERNAME_LENGTH);
        this.ip = buf.readIP();
        this.status = buf.readEnumValue(Status.class);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.sid);
        buf.writeString(this.username);
        buf.writeIP(this.ip);
        buf.writeEnumValue(status);
    }

    public enum Status {
        SUCCESFUL,
        INVALID_LAUNCHERID,
        INVALID_USERTOKEN,
        INVALID_HWID,
        INTERNAL_ERROR,
        RATE_LIMIT
    }

}