package py.com.solar.commonsapi.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OfficeEntity {

    private String name;
    private String address;
    private String phone;
    private String openingAt;
    private String city;
    private String zone;
    private String location;

}
