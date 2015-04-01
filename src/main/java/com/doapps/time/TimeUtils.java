package com.doapps.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class TimeUtils {

  public static DateTime millisToUtcDateTime(long instant) {
    return new DateTime(instant, DateTimeZone.UTC);
  }

}
