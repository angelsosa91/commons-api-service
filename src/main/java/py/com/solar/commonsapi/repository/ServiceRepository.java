package py.com.solar.commonsapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ServiceRepository {

    @Deprecated
    void callById(@Param("serviceName") String serviceName);

    @Deprecated
    void setSystemUser(@Param("username") String username);

    void initServiceUserSession(@Param("username") String username);

    String getConfidentClient(@Param("personId") long personId, @Param("username") String username);

    String getSpecialClient(@Param("username") String username, @Param("personId") long personId);

    int getPersonExists(@Param("personId") long personId);
}
