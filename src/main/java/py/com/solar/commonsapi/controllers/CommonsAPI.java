package py.com.solar.commonsapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Office;
import py.com.solar.commonsapi.models.Region;
import py.com.solar.commonsapi.service.CommonService;
import py.com.solar.commonsapi.utils.BaseAPI;

import java.util.List;

@Tag(name = "CommonAPI", description = "Responsible for returning common data from the core")
@RestController
@RequestMapping(value = BaseAPI.V1)
@RequiredArgsConstructor
public class CommonsAPI {

    private final CommonService commonService;

    @GetMapping("departments")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Region>> getProvince() throws Exception {
        return ResponseEntity.ok(commonService.getDepartments());
    }

    @GetMapping("cities/{departmentId}")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Region>> getCity(@PathVariable Integer departmentId) throws Exception {
        var result = commonService.getCitiesByDepartmentId(departmentId);
        return (result.isEmpty() ? ResponseEntity.noContent().build(): ResponseEntity.ok(result));
    }

    @GetMapping("neighborhoods/{cityId}")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Region>> getNeighborhood(@PathVariable Integer cityId) throws Exception {
        var result = commonService.getNeighborhoodsByCityId(cityId);
        return (result.isEmpty() ? ResponseEntity.noContent().build(): ResponseEntity.ok(result));
    }

    @PostMapping("notification")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Notificación enviada exitosamente")
            })
    public ResponseEntity<?> sendNotification(@RequestBody Notification notification) {
        commonService.sendNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("offices")
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<List<Office>> getAllOffices() throws Exception {
        return ResponseEntity.ok(commonService.getAllOffices());
    }
}