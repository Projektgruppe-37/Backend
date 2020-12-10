package demo.api;

import demo.model.Live;
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

    @PostMapping
    private void addLive(@RequestBody Live live) {
        liveService.addLive(live);
    }

    @GetMapping
    public List<Live> getAllBatches() {
        return liveService.getAllLive();
    }

    @DeleteMapping
    public void deleteAllLive() {
        liveService.deleteAllLive();
    }


}
