package com.doapps.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class SystemClock implements Clock {

  private DateTimeZone zone;

  private SystemClock(DateTimeZone zone) {
    this.zone = zone;
  }
  public long timestamp() {
    return System.currentTimeMillis();
  }

  public long seconds() {
    return (timestamp() / 1000l);
  }

  @Override
  public LocalDate today() {
    return new LocalDate(timestamp());
  }

  @Override
  public LocalTime time() {
    return new LocalTime(timestamp());
  }

  @Override
  public DateTime now() {
    return new DateTime(zone);
  }

  public static Clock getInstance(){
    return new SystemClock(DateTimeZone.getDefault());
  }

  public static Clock getInstance(DateTimeZone zone){
    return new SystemClock(zone);
  }
}
