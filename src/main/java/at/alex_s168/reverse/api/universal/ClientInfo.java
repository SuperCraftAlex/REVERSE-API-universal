package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.Bufferable;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;

import java.io.IOException;
import java.util.List;

public class ClientInfo implements Bufferable<ClientInfo> {

    public String name;
    public String visibleName;
    public String description;
    public String[] versions;
    public String[] authors;
    public int clientId;
    public String defaultLaunchArgs;

    public List<Downloadable> downloads;

    @Override
    public ClientInfo readData(RPacketBuffer buf) throws IOException {
        this.name = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.visibleName = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.description = buf.readString(DEF.STRING_LENGTH);
        this.versions = buf.readStringArray(2_000);
        this.authors = buf.readStringArray(30);
        this.clientId = buf.readVarInt();
        this.defaultLaunchArgs = buf.readString(DEF.STRING_LENGTH);
        this.downloads = (List<Downloadable>) buf.readList(Downloadable.class);

        return this;
    }

    @Override
    public void writeData(RPacketBuffer buf) throws IOException {
        buf.writeString(this.name);
        buf.writeString(this.visibleName);
        buf.writeString(this.description);
        buf.writeStringArray(this.versions);
        buf.writeStringArray(this.authors);
        buf.writeVarInt(this.clientId);
        buf.writeString(this.defaultLaunchArgs);
        buf.writeList(downloads);
    }

}