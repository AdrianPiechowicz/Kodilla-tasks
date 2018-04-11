package com.crud.tasks.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TrelloBoardDto {
    private String name;
    private String id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
