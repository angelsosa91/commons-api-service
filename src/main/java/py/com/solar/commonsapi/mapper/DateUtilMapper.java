package py.com.solar.commonsapi.mapper;

import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface DateUtilMapper {

    default LocalDate toLocalDate(Date date) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        }

        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    default LocalDateTime toLocalDateTime(Date date) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        }

        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}