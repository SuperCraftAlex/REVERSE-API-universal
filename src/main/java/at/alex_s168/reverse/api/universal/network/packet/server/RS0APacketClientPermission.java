package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS0APacketClientPermission implements RPacket
{
    public boolean isUseAllowed() {
        return allowUse;
    }

    private boolean allowUse;

    public RS0APacketClientPermission() {}

    public RS0APacketClientPermission(boolean allowUse) {
        this.allowUse = allowUse;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.allowUse = buf.readBoolean();
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeBoolean(allowUse);
    }

}