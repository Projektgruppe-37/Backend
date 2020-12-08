package demo.api;

import demo.model.Batch;
import demo.service.BatchService;
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


    // Possible to put in exception or something, in order to tell the user e.g. that the batch is not found
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
