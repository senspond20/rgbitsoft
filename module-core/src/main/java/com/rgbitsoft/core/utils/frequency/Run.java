package com.rgbitsoft.core.utils.frequency;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Run {

    public static void main(String[] args) {

        List<String> documentList = new ArrayList<String>(){
            {
                add("귀여운 우리 애기~ 배고프지? 우리 애기 착해");
                add("사탕 먹을까? 애기");
                add("아이스크림 먹을까? 우리~~");
                add("어머 우리 애기 맛있어요?");
                add("으구 으구 잘 먹는다 착해");
            }
        };

        DocumentFrequency frequency1 = new DocumentFrequency(documentList, "애기");

        long df1 = frequency1.getDocumentFrequency();
        double idf1 = frequency1.getInverseDocumentFrequency();

        System.out.println("DF : " + df1);
        System.out.println("IDF : " + idf1);


        DocumentFrequency frequency2 = new DocumentFrequency(documentList, "사탕");

        long df2 = frequency2.getDocumentFrequency();
        double idf2 = frequency2.getInverseDocumentFrequency();

        System.out.println("DF : " + df2);
        System.out.println("IDF : " + idf2);


    }
}
