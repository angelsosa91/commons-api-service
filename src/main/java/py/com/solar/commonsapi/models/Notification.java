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
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Notification")
public class Notification {

    @Schema(description = "Número de documento")
    @NotNull(message = "Documento obligatorio")
    @NotBlank(message = "Documento obligatorio")
    private String documentNumber;

    @Schema(description = "Tipo de Notificacion")
    @NotNull(message = "Tipo de Notificacion obligatorio")
    @NotBlank(message = "Tipo de Notificacion obligatorio")
    private String notificationType;

    @Schema(description = "Contenido de mensaje")
    @NotNull(message = "Contenido de mensaje obligatorio")
    @NotBlank(message = "Contenido de mensaje obligatorio")
    private String content;

    @Schema(description = "Número de teléfono")
    private String phoneNumber;

    @Schema(description = "Correo electrónico")
    private String email;

    @Schema(description = "Asunto del correo electrónico")
    private String emailSubject;

    @Schema(description = "Tipo de persona")
    @NotNull(message = "Tipo de persona obligatorio")
    @NotBlank(message = "Tipo de persona obligatorio")
    private String personKind;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
