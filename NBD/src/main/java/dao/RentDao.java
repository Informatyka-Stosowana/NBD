package dao;

import com.datastax.oss.driver.api.mapper.annotations.*;
import managers.RentQueryProvider;
import model.Rent;

@Dao
public interface RentDao {
    @StatementAttributes(consistencyLevel = "QUORUM")
    @Select
    Rent findById(int id);

    @StatementAttributes(consistencyLevel = "QUORUM")
    @QueryProvider(providerClass = RentQueryProvider.class)
    void save(Rent rent);

    @StatementAttributes(consistencyLevel = "QUORUM")
    @QueryProvider(providerClass = RentQueryProvider.class)
    void end(Rent rent);

    @Delete(entityClass = Rent.class)
    void deleteById(int id);
}
