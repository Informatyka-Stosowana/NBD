package model;

import storage.ClientMongoRepository;
import storage.ClientRedisRepository;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    //    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @BenchmarkMode(Mode.AverageTime)
    public void init() {
        // Do nothing
    }


    public void getClient() {
        ClientAddress clientAddress1 = new ClientAddress(1, "Mariusz", "Pudzianowski", 1, "Pudzianowska", 200, "Pudzianów", 123456);
        ClientMongoRepository clientMongoRepository = new ClientMongoRepository();
        ClientRedisRepository clientRedisRepository = new ClientRedisRepository(clientMongoRepository);
        clientRedisRepository.addClient(clientAddress1);
        clientRedisRepository.clearCache();
    }
}
