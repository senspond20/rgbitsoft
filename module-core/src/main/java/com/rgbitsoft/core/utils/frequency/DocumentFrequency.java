package com.rgbitsoft.core.utils.frequency;

import java.util.List;


/**
 *
 */
public class DocumentFrequency {
    // final 키워드와 setter를 만들지 않음으로써 생성자로 필드세팅 후 데이터 무결성 보장
    private final long documentFrequency;
    private final double inverseDocumentFrequency;

    public DocumentFrequency(List<String> documentList, String keyword){
        this.documentFrequency =  documentList.stream().filter(x -> x.contains(keyword)).count();
        this.inverseDocumentFrequency = Math.log(documentList.size() / (documentFrequency + 1));
    }
    // getter
    public long getDocumentFrequency() {
        return this.documentFrequency;
    }

    public double getInverseDocumentFrequency() {
        return this.inverseDocumentFrequency;
    }
}
