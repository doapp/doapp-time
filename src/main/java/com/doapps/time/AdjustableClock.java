package com.doapps.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * This is a clock implementation that is used primarily in testing.  It allows a user to modify the clock and the
 * timezone at runtime to try to mess with test cases.
 */
public class AdjustableClock implements Clock {

  private long timestamp = 0;
  private DateTimeZone zone = DateTimeZone.UTC;

  public AdjustableClock(long initialTimestamp) {
    this(initialTimestamp, DateTimeZone.UTC);
  }

  public AdjustableClock(long initialTimestamp, DateTimeZone initialZone) {
    this.timestamp = initialTimestamp;
    this.zone = initialZone;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
  public void setZone(DateTimeZone zone) {
    this.zone = zone;
  }
  @Override
  public long timestamp() {
    return timestamp;
  }
  @Override
  public long seconds() {
    return timestamp/1000;
  }
  @Override
  public LocalDate today() {
    return new LocalDate(timestamp, zone);
  }
  @Override
  public LocalTime time() {
    return new LocalTime(timestamp, zone);
  }
  @Override
  public DateTime now() {
    return new DateTime(timestamp, zone);
  }
}
