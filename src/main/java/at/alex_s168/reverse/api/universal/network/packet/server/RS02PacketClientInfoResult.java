package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.Client;
import at.alex_s168.reverse.api.universal.ClientInfo;

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
        this.name = buf.readVarString();
        info = new ClientInfo();

        info.name = buf.readVarString();
        info.visibleName = buf.readVarString();
        info.description = buf.readVarString();
        info.versions = buf.readVarStringArray();
        info.authors = buf.readVarStringArray();
        info.clientId = buf.readVarInt();
        info.defaultLaunchArgs = buf.readVarString();
        info.downloadsAssets = buf.readVarStringArray();
        info.downloadsLibraries = buf.readVarStringArray();
    }

    public void writePacketData(PacketBuffer buf) throws IOException{
        buf.writeVarString(this.name);

        buf.writeVarString(info.name);
        buf.writeVarString(info.visibleName);
        buf.writeVarString(info.description);
        buf.writeVarStringArray(info.versions);
        buf.writeVarStringArray(info.authors);
        buf.writeVarInt(info.clientId);
        buf.writeVarString(info.defaultLaunchArgs);
        buf.writeVarStringArray(info.downloadsAssets);
        buf.writeVarStringArray(info.downloadsLibraries);
    }

}