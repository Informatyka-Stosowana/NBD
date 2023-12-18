package storage;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;

public class RentCassandraRepository extends AbstractCassandraRepository {

    public RentCassandraRepository() {
        initSession();
        createTable();
    }

    private void createTable() {
        SimpleStatement createAccounts =
                SchemaBuilder.createTable(CqlIdentifier.fromCql("rents"))
                        .ifNotExists()
                        .withPartitionKey(CqlIdentifier.fromCql("city"), DataTypes.TEXT)
                        .withClusteringColumn(CqlIdentifier.fromCql("rentId"), DataTypes.TEXT)
                        .withColumn(CqlIdentifier.fromCql("firstName"), DataTypes.TEXT)
                        .withColumn(CqlIdentifier.fromCql("lastName"), DataTypes.TEXT)
                        .withColumn(CqlIdentifier.fromCql("noRents"), DataTypes.TEXT)
                        .withColumn(CqlIdentifier.fromCql("street"), DataTypes.TEXT)
                        .withColumn(CqlIdentifier.fromCql("streetNumber"), DataTypes.TEXT)
                        .withColumn(CqlIdentifier.fromCql("postcode"), DataTypes.TEXT)
                        .withClusteringOrder(CqlIdentifier.fromCql("rentId"), ClusteringOrder.ASC).build();
        getSession().execute(createAccounts);
    }
}
