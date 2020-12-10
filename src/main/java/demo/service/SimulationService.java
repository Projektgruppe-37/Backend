package demo.service;

import demo.dao.BatchDao;
import demo.model.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SimulationService {
    private final BatchDao batchDao;

    @Autowired
    public SimulationService(@Qualifier("simu") BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    public int addBatch(Batch batch) {
        return batchDao.insertBatch(batch);
    }
    public List<Batch> getAllBatches(){
        return batchDao.selectAllBatches();
    }
    public int deleteBatch(UUID id) {
        return batchDao.deleteBatchById(id);
    }

    public int updateProduced(UUID id, Batch newProduced) {
        return batchDao.updateProducedById(id, newProduced);

    }

}
