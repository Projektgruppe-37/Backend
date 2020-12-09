package demo.api;

import demo.model.LiveData;
import demo.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/live")

@RestController
public class LiveController {

    private final LiveService liveService;

    @Autowired
    public LiveController(LiveService liveService) {
        this.liveService = liveService;
    }

    @GetMapping
    public List<LiveData> getAllBatches() {
        return liveService.getAllLive();
    }

    @PostMapping
    private void addLive(@RequestBody LiveData liveData) {
        liveService.addLive(liveData);
    }
}

