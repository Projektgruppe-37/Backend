package demo.dao;

import demo.model.Batch;
import demo.model.LiveData;

import java.util.List;
import java.util.UUID;

public interface LiveDao {
    int insertLive(UUID id, LiveData liveData);

    default int insertLive(LiveData liveData) {
        UUID id = UUID.randomUUID();
        return insertLive(id, liveData);
    }
    List<LiveData> selectAllLive();

}



