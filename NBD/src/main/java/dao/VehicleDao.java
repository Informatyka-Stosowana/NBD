package dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.QueryProvider;
import com.datastax.oss.driver.api.mapper.annotations.StatementAttributes;
import managers.VehicleQueryProvider;
import model.Bicycle;
import model.Car;
import model.Motorcycle;
import model.Vehicle;

@Dao
public interface VehicleDao {
    @StatementAttributes(consistencyLevel = "QUORUM")
    @QueryProvider(providerClass = VehicleQueryProvider.class,
            entityHelpers = {
                    Car.class,
                    Motorcycle.class,
                    Bicycle.class})
    Vehicle findById(String id);

    @StatementAttributes(consistencyLevel = "QUORUM")
    @QueryProvider(providerClass = VehicleQueryProvider.class,
            entityHelpers = {
                    Car.class,
                    Motorcycle.class,
                    Bicycle.class})
    void save(Vehicle vehicle);

    // TODO fix this
    @Delete(entityClass = {Car.class, Bicycle.class, Motorcycle.class})
    void deleteById(String id);
}
