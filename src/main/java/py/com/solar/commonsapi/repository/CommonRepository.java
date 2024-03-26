package py.com.solar.commonsapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import py.com.solar.commonsapi.entity.NotificationEntity;
import py.com.solar.commonsapi.entity.RegionEntity;

import java.util.List;

@Mapper
public interface CommonRepository {
    List<RegionEntity> getProvince();
    List<RegionEntity> getCity(@Param("provinceId") Integer provinceId);
    List<RegionEntity> getNeighborhood(@Param("cityId") Integer cityId);
    void sendNotification(@Param("notification") NotificationEntity notification);
}
