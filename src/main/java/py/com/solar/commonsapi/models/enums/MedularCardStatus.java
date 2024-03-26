package py.com.solar.commonsapi.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MedularCardStatus {

    ACTIVE_MEDULAR("S", "Activa"),
    BLOCKED_MEDULAR("B", "Bloqueada"),
    INACTIVE_MEDULAR("I", "Inactiva"),
    CANCELED_MEDULAR("C", "Cancelada");

    private final String id;
    private final String description;
}
