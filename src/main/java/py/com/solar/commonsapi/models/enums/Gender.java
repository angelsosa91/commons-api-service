package py.com.solar.commonsapi.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(name = "Gender")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

    M("Masculino"), F("Femenino");

    private final String name;
    private final String value;

    Gender(String value) {
        name = name();
        this.value = value;
    }

}
