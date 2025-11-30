package dev.ngdangkietswe.try_spring_ai.service.impl;

import dev.ngdangkietswe.try_spring_ai.domain.InsertSoftwareEngineerReq;
import dev.ngdangkietswe.try_spring_ai.entity.SoftwareEngineer;
import dev.ngdangkietswe.try_spring_ai.repo.SoftwareEngineerRepo;
import dev.ngdangkietswe.try_spring_ai.service.AiService;
import dev.ngdangkietswe.try_spring_ai.service.SoftwareEngineerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

@Service
@RequiredArgsConstructor
@Log4j2
public class SoftwareEngineerServiceImpl implements SoftwareEngineerService {
    private final SoftwareEngineerRepo softwareEngineerRepo;
    private final AiService aiService;

    @Override
    public List<SoftwareEngineer> getListSoftwareEngineers() {
        return softwareEngineerRepo.findAll();
    }

    @Override
    public void insertSoftwareEngineer(InsertSoftwareEngineerReq req) {
        log.info("Processing insert software engineer request for name: {}, technology stack: {}", req.getName(), req.getTechnologyStack());
        var prompt = String.format(
                "Provide a very short, concise learning path for a software engineer named %s specializing in %s. Include only key topics and a brief timeline.",
                req.getName(),
                req.getTechnologyStack());
        log.info("Generated prompt for AI: {}", prompt);
        var learningPathRecommendation = aiService.chatWithAi(prompt);
        var softwareEngineer = SoftwareEngineer.builder()
                .name(req.getName())
                .technologyStack(req.getTechnologyStack())
                .learningPathRecommendation(learningPathRecommendation)
                .build();
        log.info("Processing completed, saving new software engineer with learning path recommendation.");
        softwareEngineerRepo.save(softwareEngineer);
    }

    @Override
    public SoftwareEngineer getSoftwareEngineerById(Long id) {
        return softwareEngineerRepo.findById(id).orElseThrow(() -> new RuntimeException("SoftwareEngineer with id " + id + " not found"));
    }

    @Override
    public void deleteSoftwareEngineerById(Long id) {
        boolean exists = softwareEngineerRepo.existsById(id);
        if (!exists) {
            throw new RuntimeException("SoftwareEngineer with id " + id + " not found");
        }
        softwareEngineerRepo.deleteById(id);
    }
}
