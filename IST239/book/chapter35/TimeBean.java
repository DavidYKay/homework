package chapter35;

import java.util.*;

public class TimeBean {
  private Locale[] allLocale = Locale.getAvailableLocales();
  private String[] allTimeZone = TimeZone.getAvailableIDs();
 
  public Locale[] getAllLocale() {
    return allLocale;
  }

  public String[] getAllTimeZone() {
    return allTimeZone;
  }
}
