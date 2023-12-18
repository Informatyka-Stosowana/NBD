package storage;

import com.datastax.oss.driver.api.core.CqlSession;

import java.net.InetSocketAddress;

public class AbstractCassandraRepository {
    private static CqlSession session;

    public void initSession() {
        session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("cassandral", 9042))
                .addContactPoint(new InetSocketAddress("cassandra2", 9043))
                .addContactPoint(new InetSocketAddress("cassandra3", 9044))
                .withLocalDatacenter("dcl")
                .withAuthCredentials("cassandra", "cassandrapassword")
// . withKeyspace(Cqlidenti fier. fromCql( ''rent_a_car''))
                .build();
    }
}