package py.com.solar.commonsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class NotificationEntity {
    private String documentNumber;
    private String notificationType;
    private String content;
    private String phoneNumber;
    private String email;
    private String emailSubject;
    private String personKind;
    private String response;
}
