package at.alex_s168.reverse.api.universal;

import at.alex_s168.reverse.api.universal.network.Bufferable;
import at.alex_s168.reverse.api.universal.network.RPacketBuffer;

import java.io.IOException;

public class Downloadable implements Bufferable<Downloadable> {

    private String artifactID;
    private String target;

    public String getArtifactID() {
        return artifactID;
    }

    public String getTarget() {
        return target;
    }

    public Downloadable(String artifactID, String target) {
        this.artifactID = artifactID;
        this.target = target;
    }

    public Downloadable() {

    }

    @Override
    public Downloadable readData(RPacketBuffer buf) throws IOException {
        this.artifactID = buf.readString(DEF.ARTIFACT_LENGTH);
        return this;
    }

    @Override
    public void writeData(RPacketBuffer buf) throws IOException {
        buf.writeString(this.artifactID);
    }
}
