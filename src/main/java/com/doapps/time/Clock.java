package com.doapps.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public interface Clock {

  /**
   * Returns the time stamp in milliseconds since epoch
   */
  public long timestamp();

  /**
   * Returns the time stamp in seconds since epoch
   */
  public long seconds();

  /**
   * Local date which represents a date without a time or timezone. See http://joda-time.sourceforge
   * .net/apidocs/org/joda/time/LocalDate.html
   * @return
   */
  public LocalDate today();

  /**
   * Local time which represents a time without a date or time zone. See http://joda-time.sourceforge
   * .net/apidocs/org/joda/time/LocalTime.html
   * @return
   */
  public LocalTime time();

  /**
   * Datetime which represents a date and time w/ the default timezone for this jvm
   * @return
   */
  public DateTime now();
}
