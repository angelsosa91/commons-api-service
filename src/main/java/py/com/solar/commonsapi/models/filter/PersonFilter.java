package py.com.solar.commonsapi.models.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import py.com.solar.commonsapi.models.enums.PersonTypeFilter;

@Data
@Builder
@AllArgsConstructor
@Schema(name = "PersonFilter")
public class PersonFilter {

    @Schema(description = "Nombre completo de la persona")
    private String fullName;

    @Schema(description = "Número de cuenta asociada a la persona")
    private String account;

    @Schema(description = "Número de documento de la persona")
    private String documentNumber;

    @Schema(description = "ID único de la persona")
    private String personId;

    @Schema(description = "Tipo de persona (ej. cliente, empleado, etc.)")
    private PersonTypeFilter personType;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
