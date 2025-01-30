package py.com.solar.commonsapi.mapper;

import org.mapstruct.Mapper;
import py.com.solar.commonsapi.entity.*;
import py.com.solar.commonsapi.models.*;

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

    //Office to model
    //OfficeEntity offModelToEntity(Office office);
    List<OfficeEntity> offModelToEntity(List<Office> office);
    //Office to entity
    //Office offEntityToModel(OfficeEntity officeEntity);
    List<Office> offEntityToModel(List<OfficeEntity> officeEntity);

    //Country to model
    CountryEntity countryModelToEntity(Country country);
    List<CountryEntity> countryModelToEntity(List<Country> country);
    //Region to entity
    Country countryEntityToModel(CountryEntity countryEntity);
    List<Country> countryEntityToModel(List<CountryEntity> countryEntity);

    // Sector to model
    SectorEntity secModelToEntity(Sector sector);
    List<SectorEntity> secModelToEntity(List<Sector> sector);
    // Sector to entity
    Sector secEntityToModel(SectorEntity sectorEntity);
    List<Sector> secEntityToModel(List<SectorEntity> sectorEntity);
}

