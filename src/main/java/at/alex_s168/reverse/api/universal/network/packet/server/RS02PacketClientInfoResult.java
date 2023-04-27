package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.ClientInfo;
import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.PacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.Packet;

import java.io.IOException;

public class RS02PacketClientInfoResult implements Packet
{
    public String name;

    public ClientInfo info;

    public RS02PacketClientInfoResult() {}

    public RS02PacketClientInfoResult(String name, ClientInfo info) {
        this.name = name;
        this.info = info;
    }

    public void readPacketData(PacketBuffer buf) throws IOException {
        this.name = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        info = new ClientInfo();

        info.name = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        info.visibleName = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        info.description = buf.readString(DEF.STRING_LENGTH);
        info.versions = buf.readStringArray(2_000);
        info.authors = buf.readStringArray(30);
        info.clientId = buf.readVarInt();
        info.defaultLaunchArgs = buf.readString(DEF.STRING_LENGTH);
        info.downloadsAssets = buf.readStringArray(1_000);
        info.downloadsLibraries = buf.readStringArray(1_000);
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeString(this.name);

        buf.writeString(info.name);
        buf.writeString(info.visibleName);
        buf.writeString(info.description);
        buf.writeStringArray(info.versions);
        buf.writeStringArray(info.authors);
        buf.writeVarInt(info.clientId);
        buf.writeString(info.defaultLaunchArgs);
        buf.writeStringArray(info.downloadsAssets);
        buf.writeStringArray(info.downloadsLibraries);
    }

}