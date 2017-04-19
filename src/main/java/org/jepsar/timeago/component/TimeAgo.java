package org.jepsar.timeago.component;


import java.util.Date;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import org.jepsar.timeago.util.LocaleScript;
import org.jepsar.timeago.util.Resource;
import org.jepsar.timeago.util.Script;


/**
 * Time ago component.
 *
 * @author Jasper de Vries <jepsar@gmail.com>
 */
@FacesComponent(TimeAgo.COMPONENT_TYPE)
public class TimeAgo extends UIComponentBase
{

  /**
   * Component type.
   */
  public static final String COMPONENT_TYPE = "org.jepsar.component.TimeAgo";

  /**
   * Component family.
   */
  public static final String COMPONENT_FAMILY = "org.jepsar.component.TimeAgo";

  /**
   * Default renderer.
   */
  public static final String DEFAULT_RENDERER = "org.jepsar.component.TimeAgo";


  /**
   * Property keys.
   */
  private enum PropertyKeys
  {
    value;
  }


  /**
   * {@link #setDefaultRenderer() Sets default renderer} and adds scripts to head.
   */
  public TimeAgo()
  {
    setDefaultRenderer();
    Resource.addJQueryToHead();
    Resource.addScriptToHead("jepsar", "jquery.timeago.min.js");
    Script localeScript = LocaleScript.locateTranslation();
    if (localeScript != null) {
      Resource.addScriptToHead(localeScript);
    }
  }


  /**
   * Set renderer to {@link #DEFAULT_RENDERER}.
   */
  private void setDefaultRenderer()
  {
    setRendererType(DEFAULT_RENDERER);
  }


  /**
   * Returns {@link #COMPONENT_FAMILY}.
   *
   * @return {@link #COMPONENT_FAMILY}.
   */
  @Override
  public String getFamily()
  {
    return COMPONENT_FAMILY;
  }


  /**
   * Returns value property value.
   *
   * @return value property value.
   */
  public Date getValue()
  {
    return (Date) getStateHelper().eval(PropertyKeys.value);
  }


  /**
   * Sets value property value.
   * 
   * @param value
   */
  public void setValue(Date value)
  {
    getStateHelper().put(PropertyKeys.value, value);
  }

}

