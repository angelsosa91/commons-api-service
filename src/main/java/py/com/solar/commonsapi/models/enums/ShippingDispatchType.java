package py.com.solar.commonsapi.models.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ShippingDispatchType {

    R("Retener"),
    D("Dirección"),
    C("Casilla de Correo"),
    K("Casillero");

    ShippingDispatchType(String description) {
        this.description = description;
    }

    private final String description;

    public static ShippingDispatchType getByName(String name) {
        return Arrays.asList(values()).stream()
                .filter(shippingDispatchType -> shippingDispatchType.name().equals(name))
                .findAny()
                .orElse(null);
    }
}
