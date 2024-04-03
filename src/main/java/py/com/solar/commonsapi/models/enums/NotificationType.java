package py.com.solar.commonsapi.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Arrays;

@Getter
@Schema(name = "NotificationType")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NotificationType {

    SMS("SM"), EMAIL("EMAIL"), AMBOS("AM");

    private final String name;
    private final String value;

    NotificationType(String value) {
        name = name();
        this.value = value;
    }

    public static NotificationType getByTypeCode(String code) {
        return Arrays.asList(values()).stream()
                .filter(personType -> personType.getName().equals(code))
                .findAny()
                .orElse(null);
    }

}
