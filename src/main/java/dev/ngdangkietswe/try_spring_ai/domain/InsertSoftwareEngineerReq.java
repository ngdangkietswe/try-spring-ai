package dev.ngdangkietswe.try_spring_ai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertSoftwareEngineerReq {
    private Long id;
    private String name;
    @JsonProperty("technology_stack")
    private String technologyStack;
}
