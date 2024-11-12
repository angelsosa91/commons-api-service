package py.com.solar.commonsapi.models;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Country")
public class Country {
    @Schema(description = "Codigo de pais valor único")
    private Integer id;

    @Schema(description = "Nombre o descripción del pais")
    private String name;

    @Schema(description = "Gentilicio del pais")
    private String nationality;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}