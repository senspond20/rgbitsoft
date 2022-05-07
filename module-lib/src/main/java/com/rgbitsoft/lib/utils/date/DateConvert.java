package com.rgbitsoft.lib.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 년, 월, 일 정수를 입력받아 Date 자료형으로 변환하는 클래스
 */
public class DateConvert {
    private int year;
    private int month;
    private int date;
    private Date convertDate = null;

    public DateConvert (int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date); // Zero Index
        this.convertDate = calendar.getTime();
    }

    public Date getDate(){
        return this.convertDate;
    }

    public String getString(){
        if(this.convertDate != null){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            return sf.format(this.convertDate);
        }
        return "";
    }
}
