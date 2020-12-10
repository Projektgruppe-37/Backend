package demo.dao;

import demo.model.Batch;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("simu")
public class SimulationDataAccessService implements BatchDao{

 private static ArrayList<Batch> arr;

    @Override
    public int insertBatch(UUID id, Batch batch) {

        arr = new ArrayList<>();
                arr.add(0, new Batch(id, batch.getBatchId(), batch.getProductType(), batch.getAmount(),
                batch.getProduced(), batch.getAcceptedProducts(),
                batch.getDefectProducts(), batch.getMachSpeed(),
                batch.getHumidity(), batch.getTemperature(), batch.getVibration(), batch.getCreated()));
        return 1;
    }

    @Override
    public List<Batch> selectAllBatches() {
        return arr;
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
    public int updateProducedById(UUID id, Batch batch) {
        return 0;
    }
}
