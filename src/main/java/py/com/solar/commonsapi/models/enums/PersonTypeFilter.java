package py.com.solar.commonsapi.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PersonTypeFilter {

    FISICA("F"), JURIDICA("J");

    private final String name;
    private final String value;

    PersonTypeFilter(String value) {
        name = name();
        this.value = value;
    }

}
