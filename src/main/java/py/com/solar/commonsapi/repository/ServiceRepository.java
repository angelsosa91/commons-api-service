package py.com.solar.commonsapi.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ServiceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Deprecated
    public void callById(String serviceName) {
        String sql = "begin pre_ini_aplicacion; pre_ini_programa(?,1,2); end;";
        jdbcTemplate.update(sql, serviceName);
    }

    @Deprecated
    public void setSystemUser(String username) {
        String sql = "begin RAK_SISTEMA.G_USUARIO := ?; end;";
        jdbcTemplate.update(sql, username);
    }

    public void initServiceUserSession(String username) {
        String sql = "begin pre_ini_aplicacion; pre_ini_programa('user-api-service',1,2); rak_sistema.g_usuario := UPPER(?); end;";
        jdbcTemplate.update(sql, username);
    }

    public String getConfidentClient(long personId, String username) {
        String sql = "SELECT PERSONAS.FUG_CLIENTE_CONFIDENCIAL(?,?) FROM DUAL";
        return jdbcTemplate.queryForObject(sql, String.class, personId, username);
    }

    public String getSpecialClient(String username, long personId) {
        String sql = "SELECT PERSONAS.FUG_CLIENTE_EMPLEADO(?,?) FROM DUAL";
        return jdbcTemplate.queryForObject(sql, String.class, username, personId);
    }

    public int getPersonExists(long personId) {
        String sql = "SELECT COUNT(*) FROM IT.BA_PERSONAS bp WHERE COD_PERSONA = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, personId);
        return count != null ? count : 0;
    }
}
