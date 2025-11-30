package dev.ngdangkietswe.try_spring_ai.controller;

import dev.ngdangkietswe.try_spring_ai.domain.InsertSoftwareEngineerReq;
import dev.ngdangkietswe.try_spring_ai.service.SoftwareEngineerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

@RestController
@RequestMapping("/api/v1/software-engineers")
@RequiredArgsConstructor
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerSvc;

    @GetMapping
    public ResponseEntity<?> getListSoftwareEngineers() {
        var response = softwareEngineerSvc.getListSoftwareEngineers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSoftwareEngineerById(@PathVariable Long id) {
        try {
            var response = softwareEngineerSvc.getSoftwareEngineerById(id);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> insertSoftwareEngineer(@RequestBody InsertSoftwareEngineerReq req) {
        try {
            softwareEngineerSvc.insertSoftwareEngineer(req);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSoftwareEngineerById(@PathVariable Long id) {
        try {
            softwareEngineerSvc.deleteSoftwareEngineerById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
