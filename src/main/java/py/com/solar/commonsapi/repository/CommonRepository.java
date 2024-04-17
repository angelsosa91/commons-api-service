package py.com.solar.commonsapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import py.com.solar.commonsapi.entity.MessageEntity;
import py.com.solar.commonsapi.entity.NotificationEntity;
import py.com.solar.commonsapi.entity.OfficeEntity;
import py.com.solar.commonsapi.entity.RegionEntity;

import java.util.List;

@Mapper
public interface CommonRepository {
    List<RegionEntity> getDepartments();
    List<RegionEntity> getCitiesByDepartmentId(@Param("provinceId") Integer departmentId);
    List<RegionEntity> getNeighborhoodsByCityId(@Param("cityId") Integer cityId);
    void sendNotification(@Param("notification") NotificationEntity notification, @Param("message") MessageEntity message);
    List<OfficeEntity> getAllOffices();

}
