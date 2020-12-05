/*
package demo.dao;

import demo.model.Batch;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBatchDataAccessService implements BatchDao{

    private static List<Batch> DB = new ArrayList<>();

    @Override
    public int insertBatch(UUID id, Batch batch) {
        DB.add(new Batch(id, batch.getProductType(), batch.getAmount(),
                batch.getProduced(), batch.getAcceptedProducts(),
                batch.getDefectProducts(), batch.getMachSpeed(),
                batch.getHumidity(), batch.getTemperature(), batch.getVibration()));
        return 1;
    }

    @Override
    public List<Batch> selectAllBatches() {
        return DB;
    }

    @Override
    public Optional<Batch> selectBatchById(UUID id) {
        return DB.stream()
                .filter(batch -> batch.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBatchById(UUID id) {
        Optional<Batch> batchMaybe = selectBatchById(id);
        if(batchMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(batchMaybe.get());
        return 1;

    }

    @Override
    public int updateBatchById(UUID id, Batch update) {
        return selectBatchById(id)
                .map(batch -> {
                    int indexOfBatchToUpdate = DB.indexOf(batch);
                    if (indexOfBatchToUpdate >= 0) {
                        DB.set(indexOfBatchToUpdate, new Batch(id, update.getProductType(),
                                update.getAmount(), update.getProduced(), update.getAcceptedProducts(), update.getDefectProducts(),
                                update.getMachSpeed(), update.getHumidity(), update.getTemperature(), update.getVibration()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
*/