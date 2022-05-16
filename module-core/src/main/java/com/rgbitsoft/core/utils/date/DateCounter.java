package com.rgbitsoft.core.utils.date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 시작 로컬날짜부터 endCount까지 날짜를 계산해 가져오는 클래스
 */
public class DateCounter {

    private LocalDate startDate;
    private int endCount;

    private List<DateConvert> list;

    public DateCounter(LocalDate startDate, int endCount){

        int year = startDate.getYear();
        int month = startDate.getMonthValue();
        int date = startDate.getDayOfMonth();

        list = new ArrayList<>();
        for (int idx = 0; idx <= endCount; idx++){
            DateConvert dateConvert = new DateConvert(year, month, date + idx);
            list.add(dateConvert);
        }
    }

    public int getEndCount() {
        return endCount;
    }

    public List<DateConvert> getList() {
        return list;
    }
}
