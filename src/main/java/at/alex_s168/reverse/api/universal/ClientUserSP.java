package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.RPacketBuffer;

public class ClientUserSP extends ClientUser {

    public String password;

    @Override
    public ClientUser readData(RPacketBuffer buf) {
        super.readData(buf);
        this.password = buf.readString(DEF.PASSWORD_LENGTH);
        return this;
    }

    @Override
    public void writeData(RPacketBuffer buf) {
        super.writeData(buf);
        buf.writeString(this.password);
    }
}
