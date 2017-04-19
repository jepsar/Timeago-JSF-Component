package org.jepsar.timeago.util;


import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;


/**
 * Resource utility class.
 *
 * @author Jasper de Vries <jepsar@gmail.com>
 */
public class Resource
{

  /**
   * Returns jQuery script component after adding it to head.
   *
   * @return jQuery script component.
   */
  public static UIOutput addJQueryToHead()
  {
    return addScriptToHead(JQuery.locateJQuery());
  }


  /**
   * Returns script component after adding it to head.
   *
   * @param library
   * @param name
   *
   * @return Script component.
   */
  public static UIOutput addScriptToHead(String library, String name)
  {
    UIOutput js = createScript(library, name);
    context().getViewRoot().addComponentResource(context(), js, "head");
    return js;
  }


  /**
   * Returns script component after adding it to head.
   *
   * @param script
   *
   * @return Script component.
   */
  public static UIOutput addScriptToHead(Script script)
  {
    return addScriptToHead(script.getLibrary(), script.getName());
  }


  /**
   * Returns {@code true} if the given script exists.
   *
   * @param library
   * @param name
   *
   * @return {@code true} if the given script exists.
   */
  public static boolean scriptResourceExists(String library, String name)
  {
    StringBuilder sb = new StringBuilder("/META-INF/resources/");
    if (library != null) {
      sb.append(library).append('/');
    }
    sb.append(name);
    return Resource.class.getResource(sb.toString()) != null;
  }


  /**
   * Returns {@code true} if the given script exists.
   *
   * @param script
   *
   * @return {@code true} if the given script exists.
   */
  public static boolean scriptResourceExists(Script script)
  {
    return scriptResourceExists(script.getLibrary(), script.getName());
  }


  /**
   * Returns script component.
   *
   * @param library
   * @param name
   *
   * @return Script component.
   */
  public static UIOutput createScript(String library, String name)
  {
    UIOutput js = new UIOutput();
    js.setRendererType("javax.faces.resource.Script");
    if (library != null) {
      js.getAttributes().put("library", library);
    }
    js.getAttributes().put("name", name);
    return js;
  }


  /**
   * Returns Faces context.
   *
   * @return Faces context.
   */
  public static FacesContext context()
  {
    return FacesContext.getCurrentInstance();
  }

}

