package py.com.solar.commonsapi.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OfficeEntity {

    private String description;
    private String address;
    private String phone;
    private String openingAt;
    private String cityDescription;
    private String officeZone;
    private String officeGps;

}
