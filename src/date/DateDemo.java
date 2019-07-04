package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

abstract class Demo {
    private void setmethod(){

    }
}

public class DateDemo extends Demo{
    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd HH:mm.sssZ";
        String string = "1990-01-01 05:00:00.000Z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).parse(string.replaceAll("Z$", ""));
        System.out.println("date: " + (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).format(date2));

        LocalDateTime lcd1 =
                date2.toInstant().atZone(ZoneId.ofOffset("GMT",ZoneOffset.of("-10:00"))).toLocalDateTime();


        long lcd =
                lcd1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();


        System.out.println("milis : " + lcd);
        java.util.Date date1 = Date.from( ZonedDateTime.parse( "2019-01-06T00:00:00.000Z" ).toInstant() );
        System.out.println("date1 is: " + date1);
        System.out.println("date in milis: " + date1.getTime());
//        System.out.println(String.valueOf(null));
        HashMap<String, String> compareMap = new HashMap<>();
        compareMap.put(null,null);

    }


}
