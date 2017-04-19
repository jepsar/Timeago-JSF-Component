package org.jepsar.timeago.util;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Utility class to find jQuery script resource in deployed application.
 *
 * @author Jasper de Vries <jepsar@gmail.com>
 */
public class JQuery
{

  /**
   * Logger.
   */
  private static final Logger LOG = Logger.getLogger(JQuery.class.getName());

  /**
   * Found jQuery location.
   */
  private static Script FOUND_JQUERY;

  /**
   * Locations to look for jQuery.
   */
  private static final List<Script> LOCATIONS = Arrays.asList(
                                    new Script("primefaces", "jquery/jquery.js"),
                                    new Script("bsf", "jq/jquery.js"),
                                    new Script("jepsar", "jquery.js")
                                    );


  /**
   * Returns located jQuery script.
   *
   * @return Located jQuery script.
   */
  public static Script locateJQuery()
  {
    if (FOUND_JQUERY != null) {
      return FOUND_JQUERY;
    }
    for (Script script : LOCATIONS) {
      if (Resource.scriptResourceExists(script)) {
        FOUND_JQUERY = script;
        LOG.log(Level.INFO, String.format("Found jQuery: %s", FOUND_JQUERY));
        return FOUND_JQUERY;
      }
    }
    throw new IllegalStateException("jQuery not found");
  }

}

