import java.time.LocalTime;
import java.time.ZonedDateTime;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/7 16:03
 * 4
 */
public class T1 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
    }
}
