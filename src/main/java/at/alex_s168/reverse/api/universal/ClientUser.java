package at.alex_s168.reverse.api.universal;

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
    void readData(PacketBuffer buf) {
        this.client = buf.readVarString();
        this.userName = buf.readVarString();
        this.status = buf.readVarEnum();
        this.status2 = buf.readVarString();
        this.ingameName = buf.readVarString();
    }

    @Override
    void writeData(PacketBuffer buf) {
        buf.writeVarString(client);
        buf.writeVarString(userName);
        buf.writeVarEnum(status);
        buf.writeVarString(status2);
        buf.writeVarString(ingameName);
    }

}