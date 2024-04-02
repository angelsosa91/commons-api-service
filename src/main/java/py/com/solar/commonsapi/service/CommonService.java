package py.com.solar.commonsapi.service;

import py.com.solar.commonsapi.entity.MessageEntity;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Region;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CommonService {
    List<Region> getProvince();
    List<Region> getCity(Integer provinceId);
    List<Region> getNeighborhood(Integer cityId);
    CompletableFuture<MessageEntity> sendNotification(Notification notification);
}
