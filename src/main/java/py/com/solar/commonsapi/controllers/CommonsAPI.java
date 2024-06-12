package py.com.solar.commonsapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Office;
import py.com.solar.commonsapi.models.Region;
import py.com.solar.commonsapi.service.CommonService;
import py.com.solar.commonsapi.utils.BaseAPI;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "CommonAPI", description = "Responsible for returning common data from the core")
@RestController
@RequestMapping(value = BaseAPI.V1)
@RequiredArgsConstructor
public class CommonsAPI {

    private final CommonService commonService;

    @GetMapping("departments")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Region>> getProvince() {
        return ResponseEntity.ok(commonService.getDepartments());
    }

    @GetMapping("cities/{departmentId}")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Region>> getCity(@PathVariable Integer departmentId) {
        return ResponseEntity.ok(commonService.getCitiesByDepartmentId(departmentId));
    }

    @GetMapping("neighborhoods/{cityId}")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Region>> getNeighborhood(@PathVariable Integer cityId) {
        return ResponseEntity.ok(commonService.getNeighborhoodsByCityId(cityId));
    }

    @PostMapping("notification")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<?> sendNotification(@Valid @RequestBody Notification notification) {
        commonService.sendNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("offices")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Office>> getAllOffices(){

        return ResponseEntity.ok(commonService.getAllOffices());
    }
}