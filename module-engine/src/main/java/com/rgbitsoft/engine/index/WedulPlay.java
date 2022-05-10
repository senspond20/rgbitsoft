package com.rgbitsoft.engine.index;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * studyFor
 *
 * @author wedul
 * @since 2019-02-09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(indexName = "wedul_play", type = "story")
public class WedulPlay {

    @Id
    private String id;
    private String title;
    private String user;
    private long startAt;
    private long endAt;

}
