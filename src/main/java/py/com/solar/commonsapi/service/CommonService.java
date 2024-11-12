package py.com.solar.commonsapi.service;

import py.com.solar.commonsapi.entity.MessageEntity;
import py.com.solar.commonsapi.models.Country;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Office;
import py.com.solar.commonsapi.models.Region;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CommonService {
    List<Region> getDepartments() throws Exception;
    List<Country> getCountries() throws Exception;
    List<Region> getCitiesByDepartmentId(Integer departmentId) throws Exception;
    List<Region> getNeighborhoodsByCityId(Integer cityId) throws Exception;
    CompletableFuture<MessageEntity> sendNotification(Notification notification);
    List<Office> getAllOffices() throws Exception;
}
