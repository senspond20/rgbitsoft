package com.rgbitsoft.lib.utils.date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class DateUtilsTest {

    @Test
    void test() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = DateUtils.parseDate("2022-04-1", "YYYY-MM-dd");
        System.out.println("Date1 : " + df.format(date1));

        Date date2 = DateUtils.parseDate("2022-04-30", "YYYY-MM-dd");
        System.out.println("Date2 : " + df.format(date2));

        long time = date2.getTime() - date1.getTime();

        System.out.println(time);
        Date date3 = new Date(time);
        System.out.println(date3);
    }

    @Test
    void 두날짜비교() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = df.parse("2022-04-01");
        Date date2 = df.parse("2022-04-37");
        if(date1.before(date2)){
            System.out.println("before");
        }
        System.out.println("Date1 : " + df.format(date1));
        System.out.println("Date2 : " + df.format(date2));
        long diffSec = (date2.getTime() - date1.getTime()) / 1000; //초 차이
        long diffMin = (date2.getTime() - date1.getTime()) / 60000; //분 차이
        long diffHor = (date2.getTime() - date1.getTime()) / 3600000; //시 차이
        int diffDays = (int) Math.floor(diffSec / (24*60*60)); //일자수 차이

        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");
    }

    @Test
    void 날짜비교() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = df.parse("2022-04-01");
        Date date2 = df.parse("2022-04-30");
        DateCompare dc = new DateCompare(date1, date2);
        System.out.println(dc.getBetweenDate());

    }
    @Test
    void DateConvertTest(){
        DateConvert dc = new DateConvert(2020,15,20);

        System.out.println(dc.getString());
        System.out.println(dc.getDate());

        System.out.println(dc.getRealYear());
        System.out.println(dc.getRealMonth());
        LocalDate date = LocalDate.of(2020, 04, 20);

        System.out.println(date);

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN));
        System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));
        System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN));

    }

    @Test
    void DateConvert2Test(){
        LocalDateConvert dcv = new LocalDateConvert(2020, 16, 15);

        System.out.println(dcv.getDay());
        System.out.println(dcv.getLocalDate());
        System.out.println(dcv.getDate());
    }

    @Test
    void DateUtilsTest(){

        DateCounter dd = new DateCounter(LocalDate.of(2022,04,26), 365);

        dd.getList().forEach(System.out::println);
    }
}
