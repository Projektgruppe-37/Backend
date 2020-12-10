package demo.dao;


import demo.model.LiveData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository ("live")
public class LiveDataAccessService implements LiveDao {
    private static List<LiveData> arr;

    @Override
    public int insertLive(LiveData liveData) {
        arr = new ArrayList<>();
        arr.add(new LiveData(liveData.getMaintenance(), liveData.getBarley(), liveData.getHops(), liveData.getMalt(),
                liveData.getWheat(), liveData.getYeast(), liveData.getBatchId(),
                liveData.getProductType(), liveData.getAmount(), liveData.getProduced(),
                liveData.getAcceptedProducts(), liveData.getDefectProducts(),
                liveData.getMachSpeed(), liveData.getHumidity(), liveData.getTemperature(),
                liveData.getVibration()));
    return 1;
    }

    @Override
    public List<LiveData> selectAllLive() {
        return arr;
    }
}

