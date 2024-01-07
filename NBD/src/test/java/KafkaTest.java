import model.Topic;
import org.junit.Test;

public class KafkaTest {

    @Test
    public void addTopicTest() throws InterruptedException {
        Topic topic = new Topic();
        topic.createTopic("TestTopic", 5, (short) 3);
    }
}
