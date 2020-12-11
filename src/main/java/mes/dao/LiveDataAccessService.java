package mes.dao;


import mes.model.Live;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("live")
public class LiveDataAccessService implements LiveDao {
    private static List<Live> arr;

    @Override
    public int insertLive(Live live) {
        arr = new ArrayList<>();
        arr.add(new Live(live.getMaintenance(), live.getBarley(), live.getHops(), live.getMalt(),
                live.getWheat(), live.getYeast(), live.getBatchId(),
                live.getProductType(), live.getAmount(), live.getProduced(),
                live.getAcceptedProducts(), live.getDefectProducts(),
                live.getMachSpeed(), live.getHumidity(), live.getTemperature(),
                live.getVibration()));
        return 1;
    }

    @Override
    public List<Live> selectAllLive() {
        return arr;
    }

    @Override
    public List<Live> deleteLive() {
        return arr = null;
    }
}

