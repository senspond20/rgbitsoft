package com.rgbitsoft.lib.utils.date;

import java.time.*;

import java.time.format.TextStyle;

import java.util.Date;
import java.util.Locale;

/**
 * 년, 월, 일 정수를 입력받아 날짜 자료형으로 변환
 */
public class LocalDateConvert {
    private int year;
    private int month;
    private int dateOfMonth;

    private LocalDate localDate;

    public LocalDateConvert(int year, int month, int dateOfMonth) throws DateTimeException{
        this.year = year;
        this.month = month;
        this.dateOfMonth = dateOfMonth;
        try {
            this.localDate = LocalDate.of(year, month, dateOfMonth);
        }catch (DateTimeException e){
            throw new DateTimeException("Fail Invalid value");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDateOfMonth() {
        return dateOfMonth;
    }

    public String getDay(){
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    }

    public Date getDate(){
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
//      return (Date) java.sql.Date.valueOf(localDate);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }



}
