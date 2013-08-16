package service;

import dao.MessageRedisDAO;
import domain.Message;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Service
public class DeviceDataService {
    @Autowired
    private MessageRedisDAO mrDao;

    public Set<Message> getMsgBySensor(String id){
        return mrDao.getMsgBySensor(id);
    }

    public Message getMsgBySensorAndTime(String sensor, long timestamp){
        return mrDao.getMsgBySensorAndTime(sensor,timestamp);
    }
}
