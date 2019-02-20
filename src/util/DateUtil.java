package util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: util
 * @version: 1.0
 *
 *
 * 定义一天的毫秒数,后面会用到

static long millisecondsOfOneDay = 1000*60*60*24;



把java.util.Date 的日期类型转换为java.sql.Date 的日期类型。
为什么要转呢，因为通过日期控件获取到的日期类型是java.util.Date,而在JDBC的statement中插入用的日期类型又是java.sql.Date，所以需要进行转换。

public static java.sql.Date util2sql(java.util.Date d){
return  new java.sql.Date(d.getTime());
}



获取今天，并且把时，分，秒和毫秒都置0. 因为通过日期控件获取到的日期，就是没有时分秒和毫秒的。

public static Date today()



获取月初。使用Calendar获取本月第一天。 在统计消费一览信息的时候，查看本月的消费数据，其实就是从数据库中去把从本月第一天到最后一天的数据查出来，再进行简单统计，所以需要一个获取本月第一天的方法。

public static Date monthBegin()



获取月末，和月初一个道理

public static Date monthEnd()



获取本月一共有多少天

public static int thisMonthTotalDay()



获取本月还剩多少天

thisMonthLeftDay
 */
public class DateUtil {
    public static final long millisecondsOfOneDay = 1000*60*60*24;

    public static java.sql.Date toSqlDate(Date date)
    {
        return new java.sql.Date(date.getTime());
    }

    public static Date toDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * 获取月末
     * @return
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    public static void main(String[] args)
    {
        System.out.println(new Date());
    }
}
