package py.com.solar.commonsapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Office")
public class Office {

    @NotNull(message = "Descripcion Obligatoria")
    @NotBlank(message = "Descripcion Obligatoria")
    private String description;

    @NotNull(message = "Direccion Obligatoria")
    @NotBlank(message = "Direccion Obligatoria")
    private String address;

    @NotNull(message = "Telefono Obligatoria")
    @NotBlank(message = "Telefono Obligatoria")
    private String phone;

    private String openingAt;

    @NotNull(message = "Ciudad Obligatoria")
    @NotBlank(message = "Ciudad Obligatoria")
    private String cityDescription;

    private String officeZone;

    private String officeGps;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
