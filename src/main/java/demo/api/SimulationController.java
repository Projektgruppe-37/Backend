package demo.api;

import demo.model.Batch;
import demo.service.BatchService;
import demo.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/simu")
@RestController
public class SimulationController {

        private final SimulationService simulationService;

        @Autowired
        public SimulationController(SimulationService simulationService) {
            this.simulationService = simulationService;
        }

        @PostMapping
        private void addBatch(@RequestBody Batch batch) {
            simulationService.addBatch(batch);
        }

    @GetMapping
    public List<Batch> getAllBatches() {
        return simulationService.getAllBatches();
    }

        @DeleteMapping(path = "{id}")
        public void deleteBatchById(@PathVariable("id") UUID id) {
            simulationService.deleteBatch(id);
        }

        @PutMapping(path = "{id}")
        public void updateProduced(@PathVariable("id") UUID id, @RequestBody Batch producedToUpdate) {
            simulationService.updateProduced(id, producedToUpdate);
        }
    }

