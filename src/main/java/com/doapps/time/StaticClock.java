package com.doapps.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class StaticClock implements Clock {

  final AdjustableClock internal;

  public StaticClock(long time) {
    internal = new AdjustableClock(time, DateTimeZone.UTC);
  }

  public StaticClock(long time, DateTimeZone zone) {
    internal = new AdjustableClock(time, zone);
  }

  @Override
  public long timestamp() {
    return internal.timestamp();
  }
  @Override
  public long seconds() {
    return internal.seconds();
  }
  @Override
  public LocalDate today() {
    return internal.today();
  }
  @Override
  public LocalTime time() {
    return internal.time();
  }
  @Override
  public DateTime now() {
    return internal.now();
  }
}