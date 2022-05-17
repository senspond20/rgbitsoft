package com.rgbitsoft.core.utils.date;

import java.util.Date;

/**
 * 두개의 Date 날짜(before, after)를 입력받아 비교하는 클래스
 */
public class DateCompare {
    private Date before;
    private Date after;

    private long betweenSec;
    private void updateBetweenSec(){
        this.betweenSec = (after.getTime() - before.getTime()) / 1000;
    }
    // 기본생성자 금지
    private DateCompare(){
    }

    public DateCompare(Date before, Date after){
        this.before = before;
        this.after = after;
        updateBetweenSec();
    }

    /* setter */
    public void setBefore(Date before) {
        this.before = before;
        updateBetweenSec();
    }

    public void setAfter(Date after) {
        this.after = after;
        updateBetweenSec();
    }

    /* getter */
    public Date getAfter() {
        return after;
    }

    public Date getBefore() {
        return before;
    }

    // 초 차이
    public long getBetweenSec(){
        return betweenSec;
    }

    // 분 차이
    public double getBetweenMin(){
        return (double) betweenSec / 60;
    }
    // 시간차이
    public double getBetweenHor(){
        return (double) betweenSec / 3600;
    }
    // 일 차이
    public double getBetweenDate(){
        return (double) betweenSec / 86400;
    }

}
