package dev.ngdangkietswe.try_spring_ai.service;

import dev.ngdangkietswe.try_spring_ai.domain.InsertSoftwareEngineerReq;
import dev.ngdangkietswe.try_spring_ai.entity.SoftwareEngineer;

import java.util.List;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

public interface SoftwareEngineerService {
    List<SoftwareEngineer> getListSoftwareEngineers();
    void insertSoftwareEngineer(InsertSoftwareEngineerReq req);
    SoftwareEngineer getSoftwareEngineerById(Long id);
    void deleteSoftwareEngineerById(Long id);
}
