package py.com.solar.commonsapi.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import py.com.solar.commonsapi.entity.*;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommonRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<RegionEntity> regionMapper = (rs, rowNum) ->
            RegionEntity.builder()
                    .id(rs.getInt("code"))
                    .name(rs.getString("description"))
                    .build();

    private final RowMapper<CountryEntity> countryMapper = (rs, rowNum) ->
            CountryEntity.builder()
                    .id(rs.getInt("cod_pais"))
                    .name(rs.getString("descripcion"))
                    .nationality(rs.getString("nacionalidad"))
                    .build();

    public List<RegionEntity> getDepartments() {
        String sql = "select s.cod_departamento as code, s.descripcion as description from ba_departamentos s where s.cod_departamento!=18";
        return jdbcTemplate.query(sql, regionMapper);
    }

    public List<CountryEntity> getCountries() {
        String sql = "SELECT p.cod_pais, p.descripcion, p.nacionalidad, 1 orden FROM ba_paises p WHERE p.cod_pais=586 " +
                     "UNION SELECT p.cod_pais, p.descripcion, p.nacionalidad, 2 orden FROM ba_paises p WHERE p.cod_pais!=586 ORDER BY 4, 2";
        return jdbcTemplate.query(sql, countryMapper);
    }

    public List<RegionEntity> getCitiesByDepartmentId(Integer departmentId) {
        String sql = "select s.cod_ciudad as code, s.descripcion as description from ba_ciudades s where s.cod_pais = 586 and s.cod_departamento = ?";
        return jdbcTemplate.query(sql, regionMapper, departmentId);
    }

    public List<RegionEntity> getNeighborhoodsByCityId(Integer cityId) {
        String sql = "select s.cod_barrio as code, s.descripcion as description from ba_barrios s where s.cod_pais = 586 and s.cod_ciudad = ?";
        return jdbcTemplate.query(sql, regionMapper, cityId);
    }

    public void sendNotification(NotificationEntity notification, MessageEntity message) {
        jdbcTemplate.execute(con -> {
            CallableStatement cs = con.prepareCall("{CALL PAW_HBK.pr_reg_mensajes(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, notification.getDocumentNumber());
            cs.setString(2, notification.getNotificationType());
            cs.setString(3, notification.getContent());
            cs.setString(4, notification.getPhoneNumber());
            cs.setString(5, notification.getEmail());
            cs.setString(6, notification.getEmailSubject());
            cs.setString(7, notification.getPersonKind());
            cs.registerOutParameter(8, Types.INTEGER);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.registerOutParameter(10, Types.VARCHAR);
            return cs;
        }, cs -> {
            cs.execute();
            message.setCodMensaje(cs.getInt(8));
            message.setMensaje(cs.getString(9));
            message.setTipMensaje(cs.getString(10));
            return null;
        });
    }

    public List<OfficeEntity> getAllOffices() {
        String sql = "SELECT bo.DESCRIPCION descripcion_sucursal," +
                " bo.DIRECCION  direccion_sucursal," +
                " 'Teléfono: '||bo.telefono telefono_sucursal," +
                " 'Lunes a Viernes '||sl.fun_obt_vmax_referencias('HORARIO_HB','HORARIO_HB') horario_atencion," +
                " bc.DESCRIPCION descripcion_ciudad," +
                " DECODE(bd.COD_DEPARTAMENTO,'11','Asunción y Gran Asunción','Interior del País') zona_sucursal," +
                " bo.UBICACION ubicacion_sucursal" +
                " FROM    BA_OFICINAS bo, BA_CIUDADES bc, BA_DEPARTAMENTOS bd" +
                " WHERE bo.COD_CIUDAD  = bc.COD_CIUDAD" +
                " AND bo.COD_PAIS  = bc.COD_PAIS" +
                " AND bc.COD_DEPARTAMENTO  = bd.COD_DEPARTAMENTO" +
                " AND bo.ESTADO ='A'" +
                " ORDER BY bc.COD_DEPARTAMENTO";
        return jdbcTemplate.query(sql, (rs, rowNum) -> OfficeEntity.builder()
                .name(rs.getString("descripcion_sucursal"))
                .address(rs.getString("direccion_sucursal"))
                .phone(rs.getString("telefono_sucursal"))
                .openingAt(rs.getString("horario_atencion"))
                .city(rs.getString("descripcion_ciudad"))
                .zone(rs.getString("zona_sucursal"))
                .location(rs.getString("ubicacion_sucursal"))
                .build());
    }

    public MessageEntity getErrorMessage(int errorId) {
        String sql = "select b.cod_mensaje codMensaje, b.mensaje, b.tip_mensaje tipMensaje from bw_men_servicios b where b.cod_mensaje = ?";
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                return MessageEntity.builder()
                        .codMensaje(rs.getInt("codMensaje"))
                        .mensaje(rs.getString("mensaje"))
                        .tipMensaje(rs.getString("tipMensaje"))
                        .build();
            }
            return null;
        }, errorId);
    }

    public List<SectorEntity> getSectors() {
        String sql = "select cod_rub_economico as code, des_rub_superior as description from ge_rub_economicos where cod_rub_eco_superior = cod_rub_economico order by descripcion asc";
        return jdbcTemplate.query(sql, (rs, rowNum) -> SectorEntity.builder()
                .id(rs.getString("code"))
                .name(rs.getString("description"))
                .build());
    }
}
