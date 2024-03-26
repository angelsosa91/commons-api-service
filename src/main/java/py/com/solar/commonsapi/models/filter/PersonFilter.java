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

    private String fullName;
    private String account;
    private String documentNumber;
    private String personId;
    private PersonTypeFilter personType;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
