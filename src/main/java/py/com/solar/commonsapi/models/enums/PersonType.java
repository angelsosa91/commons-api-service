package py.com.solar.commonsapi.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Arrays;

@Getter
@Schema(name = "PersonType")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PersonType {

    F("Fisica"), J("Juridica");

    private final String name;
    private final String value;

    PersonType(String value) {
        name = name();
        this.value = value;
    }

    public static PersonType getByTypeCode(String code) {
        return Arrays.asList(values()).stream()
                .filter(personType -> personType.getName().equals(code))
                .findAny()
                .orElse(null);
    }

}
