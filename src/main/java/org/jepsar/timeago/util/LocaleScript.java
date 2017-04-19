package org.jepsar.timeago.util;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * Utility class to find locale script resource in deployed application based on view locale.
 *
 * @author Jasper de Vries <jepsar@gmail.com>
 */
public class LocaleScript
{

  /**
   * LocaleScript scripts cache.
   */
  private static final Map<Locale, Script> TRANSLATIONS = new HashMap<>();


  /**
   * Returns script for given locale ({@code null} if none found).
   *
   * @param locale
   *
   * @return Script for given locale ({@code null} if none found).
   */
  public static Script locateTranslation(Locale locale)
  {
    if (TRANSLATIONS.containsKey(locale)) {
      return TRANSLATIONS.get(locale);
    }
    List<String> options = Arrays.asList(
                 locale.getLanguage() + "-" + locale.getCountry().toLowerCase(),
                 locale.getLanguage() + "-" + locale.getCountry(),
                 locale.getLanguage()
                 );
    for (String option : options) {
      Script script = new Script("jepsar",
                                 String.format("locale/jquery.timeago.%s.js", option));
      if (Resource.scriptResourceExists(script)) {
        TRANSLATIONS.put(locale, script);
        return script;
      }
    }
    TRANSLATIONS.put(locale, null);
    return null;
  }


  /**
   * Returns script for view root locale ({@code null} if none found).
   *
   * @return Script for view root locale ({@code null} if none found).
   */
  public static Script locateTranslation()
  {
    return locateTranslation(Resource.context().getViewRoot().getLocale());
  }

}

