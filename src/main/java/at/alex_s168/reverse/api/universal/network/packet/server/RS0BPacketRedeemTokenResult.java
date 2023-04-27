package at.alex_s168.reverse.api.universal.network.packet.server;

import at.alex_s168.reverse.api.universal.DEF;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;
import at.alex_s168.reverse.api.universal.network.packet.RPacket;

import java.io.IOException;

public class RS0BPacketRedeemTokenResult implements RPacket
{
    public Result result;
    public String redeemedClient;

    public RS0BPacketRedeemTokenResult() {}

    public RS0BPacketRedeemTokenResult(Result result, String redeemedClient) {
        this.result = result;
        this.redeemedClient = redeemedClient;
    }

    public void readPacketData(RPacketBuffer buf) throws IOException {
        this.result = buf.readEnumValue(Result.class);
        this.redeemedClient = buf.readString(DEF.CLIENTNAME_MAX_LENGTH);
    }

    public void writePacketData(RPacketBuffer buf) throws IOException{
        buf.writeEnumValue(this.result);
        buf.writeString(redeemedClient);
    }

    public enum Result {
        SUCCES,
        INVALID_TOKEN,
        INVALID_SESSION,
        INTERNAL_ERROR
    }

}