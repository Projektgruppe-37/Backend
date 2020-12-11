package mes.api;

import mes.model.Batch;
import mes.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/batch")

@RestController
public class BatchController {

    private final BatchService batchService;

    @Autowired
    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    private void addBatch(@RequestBody Batch batch) {
        batchService.addBatch(batch);
    }

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping(path = "{id}")
    public Batch getBatchById(@PathVariable("id") UUID id) {
        return batchService.getBatchById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBatchById(@PathVariable("id") UUID id) {
        batchService.deleteBatch(id);
    }

    @PutMapping(path = "{id}")
    public void updateProduced(@PathVariable("id") UUID id, @RequestBody Batch producedToUpdate) {
        batchService.updateProduced(id, producedToUpdate);
    }
}
