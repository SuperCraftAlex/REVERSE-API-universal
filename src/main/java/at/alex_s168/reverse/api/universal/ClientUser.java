package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.PacketBuffer;

public class ClientUser implements Bufferable {

    public String client;
    public String userName;
    public Status status;
    public String status2;
    public String ingameName;

    public enum Status {
        IN_MENU,
        INGAME_OFFLINE,
        INGAME_ONLINE,
        AFK,
        OFFLINE
    }

    @Override
    public ClientUser readData(PacketBuffer buf) {
        this.client = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
        this.userName = buf.readString(DEF.USERNAME_LENGTH);
        this.status = buf.readEnumValue(Status.class);
        this.status2 = buf.readString(30);
        this.ingameName = buf.readString(DEF.USERNAME_LENGTH);

        return this;
    }

    @Override
    public void writeData(PacketBuffer buf) {
        buf.writeString(client);
        buf.writeString(userName);
        buf.writeEnumValue(status);
        buf.writeString(status2);
        buf.writeString(ingameName);
    }

}