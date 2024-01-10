package kafka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaRent {
    @JsonProperty("clientId")
    private int clientId;
    @JsonProperty("vehicleId")
    private String vehicleId;
    @JsonProperty("id")
    private int id;
    @JsonProperty("archive")
    private boolean archive;

    @JsonCreator

    public KafkaRent(@JsonProperty("id") int id,
                     @JsonProperty("clientId") int clientId,
                     @JsonProperty("vehicleId") String vehicleId) {
        this.id = id;
        this.archive = false;
        this.clientId = clientId;
        this.vehicleId = vehicleId;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }


}
