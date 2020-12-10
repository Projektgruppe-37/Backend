package demo.dao;

import demo.model.Batch;
import demo.model.LiveData;

import java.util.List;
import java.util.UUID;

public interface LiveDao {

    default int insertLive(LiveData liveData) {
        return insertLive(liveData);
    }
    List<LiveData> selectAllLive();

}




