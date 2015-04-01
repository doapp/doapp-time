import com.doapps.time.Clock;
import com.doapps.time.SystemClock;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SystemClockTest {

  @Test
  public void testTimestamp(){
    Long start = System.currentTimeMillis();
    Clock clock = SystemClock.getInstance();
    long timestamp = clock.timestamp();
    Long end = System.currentTimeMillis();
    assertThat((Long)timestamp, Matchers.<Long>both(greaterThanOrEqualTo(start)).and(lessThanOrEqualTo(end)));
  }

  @Test
  public void testSeconds(){
    Long start = System.currentTimeMillis()/1000;
    Clock clock = SystemClock.getInstance();
    long  seconds = clock.seconds();
    Long end = System.currentTimeMillis()/1000;
    assertThat((Long)seconds, Matchers.<Long>both(greaterThanOrEqualTo(start)).and(lessThanOrEqualTo(end)));
  }
}
