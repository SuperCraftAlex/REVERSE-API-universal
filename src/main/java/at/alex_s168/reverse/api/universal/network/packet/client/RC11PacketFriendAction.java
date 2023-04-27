package at.alex_s168.reverse.api.universal.network.packet.client;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RC11PacketFriendAction implements RPacket
{
    public String launchToken;
    public String username;
    public Action action;

    public RC11PacketFriendAction() {}

    public RC11PacketFriendAction(String launchToken, String username, Action action) {
        this.launchToken = launchToken;
        this.username = username;
        this.action = action;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.launchToken = buf.readString(DEF.LAUNCHTOKEN_LENGTH);
        this.username = buf.readString(DEF.USERNAME_LENGTH);
        this.action = buf.readEnumValue(Action.class);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeString(this.launchToken);
        buf.writeString(this.username);
        buf.writeEnumValue(this.action);
    }

    public enum Action {
        ADD,
        REMOVE
    }

}