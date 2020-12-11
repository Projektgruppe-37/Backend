package mes.dao;

import mes.model.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class BatchDataAccessService implements BatchDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BatchDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertBatch(UUID batchId, Batch batch) {
        @SuppressWarnings("SqlResolve") final String sql = "INSERT INTO data (id, batch_id, product_type, amount, produced, accepted_products, " +
                "defect_products, mach_speed, humidity, temperature, vibration, created) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                batchId,
                batch.getBatchId(),
                batch.getProductType(),
                batch.getAmount(),
                batch.getProduced(),
                batch.getAcceptedProducts(),
                batch.getDefectProducts(),
                batch.getMachSpeed(),
                batch.getHumidity(),
                batch.getTemperature(),
                batch.getVibration(),
                batch.getCreated()
        );
    }

    @Override
    public List<Batch> selectAllBatches() {
        @SuppressWarnings("SqlResolve") final String sql = "SELECT id, batch_id, product_type, amount, produced, accepted_products, " +
                "defect_products, mach_speed, humidity, temperature, vibration, created FROM data";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            int batch_id = resultSet.getInt("batch_id");
            float product_type = resultSet.getFloat("product_type");
            float amount = resultSet.getFloat("amount");
            int produced = resultSet.getInt("produced");
            int accepted_products = resultSet.getInt("accepted_products");
            int defect_products = resultSet.getInt("defect_products");
            float mach_speed = resultSet.getFloat("mach_speed");
            float humidity = resultSet.getFloat("humidity");
            float temperature = resultSet.getFloat("temperature");
            float vibration = resultSet.getFloat("vibration");
            Timestamp created = resultSet.getTimestamp("created");

            return new Batch(id, batch_id, product_type, amount, produced, accepted_products,
                    defect_products, mach_speed, humidity, temperature, vibration, created);
        });
    }

    @Override
    public Optional<Batch> selectBatchById(UUID id) {
        @SuppressWarnings("SqlResolve") final String sql = "SELECT id, batch_id, product_type, amount, produced, accepted_products, " +
                "defect_products, mach_speed, humidity, temperature, vibration, created FROM data WHERE id = ?";
        Batch batch = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID batchId = UUID.fromString(resultSet.getString("id"));
                    int batch_id = resultSet.getInt("batch_id");
                    float product_type = resultSet.getFloat("product_type");
                    float amount = resultSet.getFloat("amount");
                    int produced = resultSet.getInt("produced");
                    int accepted_products = resultSet.getInt("accepted_products");
                    int defect_products = resultSet.getInt("defect_products");
                    float mach_speed = resultSet.getFloat("mach_speed");
                    float humidity = resultSet.getFloat("humidity");
                    float temperature = resultSet.getFloat("temperature");
                    float vibration = resultSet.getFloat("vibration");
                    Timestamp created = resultSet.getTimestamp("created");

                    return new Batch(batchId, batch_id, product_type, amount, produced, accepted_products,
                            defect_products, mach_speed, humidity, temperature, vibration, created);
                });
        return Optional.ofNullable(batch);
    }

    @Override
    public int deleteBatchById(UUID id) {
        @SuppressWarnings("SqlResolve") String sql = "DELETE FROM data WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateProducedById(UUID id, Batch batch) {
        @SuppressWarnings("SqlResolve") String sql = "UPDATE data SET amount = ? WHERE id = ?";
        return jdbcTemplate.update(sql, batch, id);
    }
}
