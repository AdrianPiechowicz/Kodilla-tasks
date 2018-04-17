package com.crud.tasks.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;

}
