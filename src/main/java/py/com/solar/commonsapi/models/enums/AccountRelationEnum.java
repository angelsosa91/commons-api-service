package py.com.solar.commonsapi.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountRelationEnum {

    PRINCIPAL("P", "Principal"),
    FIRMANTE_CONJ("Y", "Firmante Conj"),
    FIRMANTE_IND("O", "Firmante Ind"),
    GARANTE("G", "Garante"),
    COD_DEUDOR("C", "Cod. Deudor"),
    ADICIONAL("A", "Adicional"),
    B("B", ""),
    I("I", ""),
    R("R", "");

    private String code;
    private String description;

    public static final AccountRelationEnum getByCode(String code) {
        return Arrays.stream(values())
                .filter(accountRelationEnum -> accountRelationEnum.getCode().equals(code))
                .findAny()
                .orElse(null);

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
