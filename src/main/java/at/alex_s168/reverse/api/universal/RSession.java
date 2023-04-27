package at.alex_s168.reverse.api.universal;

import java.net.InetAddress;

public class RSession {

    private final String sessionID;
    private final InetAddress serverIP;

    public String getSessionID() {
        return sessionID;
    }

    public InetAddress getServerIP() {
        return serverIP;
    }

    public RSession(String sessionID, InetAddress serverIP) {
        this.sessionID = sessionID;
        this.serverIP = serverIP;
    }
}
