package com.rgbitsoft.engine.repository;

import com.rgbitsoft.engine.index.ReservationIndex;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.util.UUID;

@RequiredArgsConstructor
public class ElasticSearchIndexer {
    private final ElasticsearchOperations elasticsearchOperations;
    //private final ElasticSearchClient elasticSearchClient;

    /**
     * create Index (reservation)
     * @return
     */
    public String createIndex() {
        IndexCoordinates indexCoordinates = elasticsearchOperations.getIndexCoordinatesFor(ReservationIndex.class);
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(UUID.randomUUID().toString())
                .withObject(new ReservationIndex())
                .build();

        return elasticsearchOperations.index(indexQuery, indexCoordinates);
    }


}
