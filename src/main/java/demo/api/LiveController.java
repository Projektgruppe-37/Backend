package demo.api;

import demo.model.LiveData;
import demo.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/live")

@RestController
public class LiveController {

    private final LiveService liveService;

    @Autowired
    public LiveController(LiveService liveService) {
        this.liveService = liveService;
    }

    @PostMapping
    private void addLive(@RequestBody LiveData liveData) {
        liveService.addLive(liveData);
    }
}
