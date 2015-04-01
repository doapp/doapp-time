import com.doapps.time.AdjustableClock;
import com.doapps.time.Clock;

import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class AdjustableClockTest {

  public static final long MARCH312015_194723GMT_MSEC_SINCE_EPOCH =  1427831243000l;
  @Test
  public void testTimestampWithoutZone(){
    //should use UTC
    AdjustableClock clock = new AdjustableClock(MARCH312015_194723GMT_MSEC_SINCE_EPOCH);
    assertThat(clock.timestamp(), is(MARCH312015_194723GMT_MSEC_SINCE_EPOCH));
  }

  @Test
  public void testSecondsWithoutZone(){
    //should use UTC
    AdjustableClock clock = new AdjustableClock(MARCH312015_194723GMT_MSEC_SINCE_EPOCH);
    assertThat(clock.seconds(), is(MARCH312015_194723GMT_MSEC_SINCE_EPOCH / 1000));
  }

  @Test
  public void testLocalTimeWithoutZone(){
    AdjustableClock clock = new AdjustableClock(MARCH312015_194723GMT_MSEC_SINCE_EPOCH);
    LocalTime time = clock.time();
    assertThat(time.getHourOfDay(), is(19));
    assertThat(time.getMinuteOfHour(), is(47));
    assertThat(time.getSecondOfMinute(), is(23));
  }

  @Test
  public void testLocalDateWithoutZone(){
    AdjustableClock clock = new AdjustableClock(MARCH312015_194723GMT_MSEC_SINCE_EPOCH);
    LocalDate date = clock.today();
    assertThat(date.getMonthOfYear(), is(3));
    assertThat(date.getDayOfMonth(), is(31));
    assertThat(date.getYear(), is(2015));
  }

  @Test
  public void testDateWithUTC(){
    AdjustableClock clock = new AdjustableClock(MARCH312015_194723GMT_MSEC_SINCE_EPOCH, DateTimeZone.UTC);
    DateTime dateTime = clock.now();
    assertThat(dateTime.getHourOfDay(), is(19));
    assertThat(dateTime.getMinuteOfHour(), is(47));
    assertThat(dateTime.getSecondOfMinute(), is(23));
    assertThat(dateTime.getMonthOfYear(), is(3));
    assertThat(dateTime.getDayOfMonth(), is(31));
    assertThat(dateTime.getYear(), is(2015));

    DateTimeZone zone = DateTimeZone.forOffsetHours(-5);
    clock.setZone(zone);
    dateTime = clock.now();
    assertThat(dateTime.getHourOfDay(), is(14));
    assertThat(dateTime.getMinuteOfHour(), is(47));
    assertThat(dateTime.getSecondOfMinute(), is(23));
    assertThat(dateTime.getMonthOfYear(), is(3));
    assertThat(dateTime.getDayOfMonth(), is(31));
    assertThat(dateTime.getYear(), is(2015));
  }

  @Test
  public void testAdjust(){
    AdjustableClock clock = new AdjustableClock(MARCH312015_194723GMT_MSEC_SINCE_EPOCH);
    System.out.println(MARCH312015_194723GMT_MSEC_SINCE_EPOCH);
    DateTime now = clock.now();
    now = now.plusHours(4);
    clock.setTimestamp(now.getMillis());
    System.out.println(now.getMillis());
    DateTime dateTime = clock.now();
    assertThat(dateTime.getHourOfDay(), is(23));
    assertThat(dateTime.getMinuteOfHour(), is(47));
    assertThat(dateTime.getSecondOfMinute(), is(23));
    assertThat(dateTime.getMonthOfYear(), is(3));
    assertThat(dateTime.getDayOfMonth(), is(31));
    assertThat(dateTime.getYear(), is(2015));
  }
}
