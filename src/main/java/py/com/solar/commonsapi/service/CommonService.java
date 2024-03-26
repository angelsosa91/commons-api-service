package py.com.solar.commonsapi.service;

import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Region;

import java.util.List;

public interface CommonService {
    List<Region> getProvince();
    List<Region> getCity(Integer provinceId);
    List<Region> getNeighborhood(Integer cityId);
    void sendNotification(Notification notification);
}
