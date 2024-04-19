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

    @Schema(description = "Nombre o descripción de la oficina")
    @NotNull(message = "Descripcion Obligatoria")
    @NotBlank(message = "Descripcion Obligatoria")
    private String name;

    @Schema(description = "Dirección")
    @NotNull(message = "Direccion Obligatoria")
    @NotBlank(message = "Direccion Obligatoria")
    private String address;

    @Schema(description = "Número de telefono")
    @NotNull(message = "Telefono Obligatoria")
    @NotBlank(message = "Telefono Obligatoria")
    private String phone;

    @Schema(description = "Lugar, sector o sucursal de apertura")
    private String openingAt;

    @Schema(description = "Ciudad")
    @NotNull(message = "Ciudad Obligatoria")
    @NotBlank(message = "Ciudad Obligatoria")
    private String city;

    @Schema(description = "Zona")
    private String zone;

    @Schema(description = "Localización")
    private String location;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
