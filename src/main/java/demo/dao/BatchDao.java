package demo.dao;

import demo.model.Batch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BatchDao {
    int insertBatch(UUID id, Batch batch);

    default int insertBatch(Batch batch) {
        UUID id = UUID.randomUUID();
        return insertBatch(id, batch);
    }

    List<Batch> selectAllBatches();

    Optional<Batch> selectBatchById(UUID id);

    int deleteBatchById(UUID id);

    int updateBatchById(UUID id, Batch batch);
}
