import com.fasterxml.jackson.core.JsonProcessingException;
import kafka.KafkaRent;
import kafka.Producer;
import model.Car;
import model.ClientAddress;
import model.Vehicle;
import org.junit.jupiter.api.Test;

public class KafkaProducerTest {

    @Test
    public void producerTest() throws InterruptedException, JsonProcessingException {
        ClientAddress clientAddress = new ClientAddress(1, "Pablo", "Escobar", "Uliczna", 1, "Mehiko", 121212);
        Vehicle vehicle = new Car("1", 100, "Pink", 0.0000001, 0, 15);
        KafkaRent kafkaRent = new KafkaRent(1, clientAddress.getPersonalId(), vehicle.getId());

        Producer producer = new Producer();
        producer.initProducer();
        producer.sendMessageAsync(kafkaRent);
    }
}
