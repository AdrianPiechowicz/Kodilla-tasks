package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgeDto {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByTypeDto")
    private AttachmentsByTypeDto attachmentsByTypeDto;
}
