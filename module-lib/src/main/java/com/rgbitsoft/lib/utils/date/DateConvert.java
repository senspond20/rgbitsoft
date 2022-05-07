package com.rgbitsoft.lib.utils.date;

import lombok.ToString;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
//import java.util.GregorianCalendar;

/**
 * 년, 월, 일 정수를 입력받아 Date/LocalDate 자료형으로 변환
 */
@ToString
public class DateConvert {

    private Date date = null;

    private int realYear;
    private int realMonth;
    private int realDate;

    private LocalDate localDate;

    /**
     * 실제 달력에 없는 정수도 들어갈 수 있음. 그래도 오류안나게 처리
     * @param year
     * @param month
     * @param date
     * @throws DateTimeException
     */
    public DateConvert (int year, int month, int date) {
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Soul"));
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Soul"));
        cal.set(year, month - 1, date); // Zero Index
        this.date = cal.getTime();
        //  this.convertDate = new GregorianCalendar(year, month - 1, date).getTime();

        this.realYear = cal.get(Calendar.YEAR);
        this.realMonth = cal.get(Calendar.MONTH) + 1;
        this.realDate = cal.get(Calendar.DATE);
        this.localDate = LocalDate.of(realYear, realMonth, realDate);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Date getDate(){
        return this.date;
    }

    public int getRealDate() {
        return realDate;
    }

    public int getRealMonth() {
        return realMonth;
    }

    public int getRealYear() {
        return realYear;
    }

    public String getRealDay(){
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    }

    public String getString(){
        if(this.date != null){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            return sf.format(this.date);
        }
        return "";
    }
}
