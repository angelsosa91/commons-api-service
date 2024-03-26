package py.com.solar.commonsapi.mapper;

import org.mapstruct.Mapper;
import py.com.solar.commonsapi.entity.NotificationEntity;
import py.com.solar.commonsapi.entity.RegionEntity;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Region;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CommonMapper {
    //Notification to model
    NotificationEntity notModelToEntity(Notification model);
    List<NotificationEntity> notModelToEntity(List<Notification> model);
    //Notification to entity
    Notification notEntityToModel(NotificationEntity entity);
    List<Notification> notEntityToModel(List<NotificationEntity> entity);

    //Region to model
    RegionEntity regModelToEntity(Region model);
    List<RegionEntity> regModelToEntity(List<Region> model);
    //Region to entity
    Region regEntityToModel(RegionEntity entity);
    List<Region> regEntityToModel(List<RegionEntity> entity);
}

