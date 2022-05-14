package com.techeer.inforplanbackend.domain.list.dto.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
@AllArgsConstructor
public class BoardListResponseDto {

    private Long list_id;
    private String list_title;
    private Date created_at;
    private Date updated_at;
}
