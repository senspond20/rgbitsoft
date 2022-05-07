package com.rgbitsoft.lib.utils.date;

import java.util.Date;

/**
 * 두개의 Date 날짜를 입력받아 비교하는 클래스
 */
public class DateCompare {
    private Date before;
    private Date after;

    private long betweenMsec;
    private long betweenSec;

    private DateCompare(){
    }

    public DateCompare(Date before, Date after){
        this.before = before;
        this.after = after;
        betweenMsec = after.getTime() - before.getTime();
        betweenSec = betweenMsec / 1000;
    }

    public long getBetweenMsec(){
        return betweenMsec;
    }
    public long getBetweenSec(){
        return betweenSec;
    }

    // 분 차이
    public long getBetweenMin(){
        return betweenSec / 60;
    }
    // 시간차이
    public long getBetweenHor(){
        return betweenSec / 3600;
    }
    // 일 차이
    public int getBetweenDate(){
        return (int) Math.floor(betweenSec / 86400);
    }

}
