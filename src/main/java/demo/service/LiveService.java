package demo.service;

import demo.dao.LiveDao;
import demo.model.LiveData;
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

    public int addLive(LiveData liveData) {
        return liveDao.insertLive(liveData);
    }

    public List<LiveData> getAllLive(){
        return liveDao.selectAllLive();
    }
}


