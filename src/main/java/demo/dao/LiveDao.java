package demo.dao;

import demo.model.Live;

import java.util.List;

public interface LiveDao {

    default int insertLive(Live live) {
        return insertLive(live);
    }
    List<Live> selectAllLive();

    List<Live> deleteLive();

}




