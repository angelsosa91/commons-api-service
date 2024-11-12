package py.com.solar.commonsapi.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CountryEntity {
    private Integer id;
    private String name;
    private String nationality;
}
