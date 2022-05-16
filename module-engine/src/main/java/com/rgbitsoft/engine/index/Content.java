package com.rgbitsoft.engine.index;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.util.Date;


@ToString
@Data
@EqualsAndHashCode(of = "id")
@Document(indexName = "content-v5", type = "_doc", shards = 1, replicas = 0)
@NoArgsConstructor
public class Content {

    @Id
    private String id;
    private String title;
    private String content;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date createAt;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date updateAt;

    @Builder
    public Content(String title, String content){
        this.title = title;
        this.content = content;
        this.createAt = new Date();
        this.updateAt = this.createAt;
    }

    public Content update(String title, String content) {
        this.title = title;
        this.content = content;
        this.updateAt = new Date();
        return this;
    }
}
