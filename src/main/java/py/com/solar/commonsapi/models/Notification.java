package py.com.solar.commonsapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static py.com.solar.commonsapi.utils.DateFormatUtils.DEFAULT_DATE_TIME_FORMAT;

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
    @NotNull(message = "Celular obligatorio")
    @NotBlank(message = "Celular obligatorio")
    private String phoneNumber;

    @Schema(description = "Correo electrónico")
    @NotNull(message = "Email obligatorio")
    @NotBlank(message = "Email obligatorio")
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
