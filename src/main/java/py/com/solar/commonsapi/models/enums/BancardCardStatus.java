package py.com.solar.commonsapi.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BancardCardStatus {

    ACTIVE("A", "Activa"),
    BLOCKED("B", "Bloqueada"),
    INACTIVE("I", "Inactiva"),
    CANCELED("C", "Cancelada");

    private final String id;
    private final String description;
}
