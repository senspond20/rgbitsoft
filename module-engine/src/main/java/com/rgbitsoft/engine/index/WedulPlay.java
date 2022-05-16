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

@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(indexName = "wedul_play")
public class WedulPlay {

    @Id
    private String id;
    private String title;
    private String user;
    private long startAt;
    private long endAt;

    @Builder
    public WedulPlay(String id, String title, String user, long startAt, long endAt){
        this.id = id;
        this.title = title;
        this.user = user;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
