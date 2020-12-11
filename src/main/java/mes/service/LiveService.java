package mes.service;

import mes.dao.LiveDao;
import mes.model.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveService {
    private final LiveDao liveDao;


    @Autowired
    public LiveService(@Qualifier("live") LiveDao liveDao) {
        this.liveDao = liveDao;
    }

    public int addLive(Live live) {
        return liveDao.insertLive(live);
    }

    public List<Live> getAllLive() {
        return liveDao.selectAllLive();
    }

    public List<Live> deleteAllLive() {
        return liveDao.deleteLive();

    }
}


