package demo.dao;

import demo.model.Batch;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class BatchDataAccessService implements BatchDao {
    @Override
    public int insertBatch(UUID id, Batch batch) {
        return 0;
    }

    @Override
    public List<Batch> selectAllBatches() {
        return List.of(new Batch(UUID.randomUUID(), 1, 2, 3, 4, 5,6,
        7, 8, 9));
    }

    @Override
    public Optional<Batch> selectBatchById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteBatchById(UUID id) {
        return 0;
    }

    @Override
    public int updateBatchById(UUID id, Batch batch) {
        return 0;
    }
}
