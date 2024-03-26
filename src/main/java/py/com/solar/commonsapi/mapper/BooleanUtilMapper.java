package py.com.solar.commonsapi.mapper;

import org.mapstruct.Mapper;

import static org.apache.commons.lang3.StringUtils.*;

@Mapper(componentModel = "spring")
public interface BooleanUtilMapper {

    default Boolean convertFrom(String value) {
        if (isBlank(value)) {
            return null;
        }

        switch (value) {
            case "A":
            case "S":
            case "s":
            case "true":
            case "TRUE":
                return Boolean.TRUE;
            case "I":
            case "N":
            case "n":
            case "false":
            case "FALSE":
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    default String convertToString(Boolean value){
        if (value == null){
            return null;
        } else if (value){
            return "S";
        } else {
            return "N";
        }
    }

}