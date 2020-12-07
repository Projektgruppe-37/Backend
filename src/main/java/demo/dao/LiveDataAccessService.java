package demo.dao;


import demo.model.LiveData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository ("live")
public class LiveDataAccessService implements LiveDao {
    private static List<LiveData> DB = new ArrayList<>();

    @Override
    public int insertLive(UUID id, LiveData liveData) {
        int x = Integer.parseUnsignedInt(String.valueOf(liveData.getProducedLive()));

        DB.add(new LiveData(id, x));
    return 1;
    }
}

