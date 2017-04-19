package org.jepsar.timeago.util;


/**
 * Simple model to hold script information.
 *
 * @author Jasper de Vries <jepsar@gmail.com>
 */
public class Script
{

  /**
   * Library.
   */
  private String library;

  /**
   * Name.
   */
  private String name;


  /**
   *
   * @param library
   * @param name
   */
  public Script(String library, String name)
  {
    this.library = library;
    this.name = name;
  }


  /**
   * Returns {@link #library}.
   *
   * @return {@link #library}.
   */
  public String getLibrary()
  {
    return library;
  }


  /**
   * Sets {@link #library}.
   *
   * @param library
   */
  public void setLibrary(String library)
  {
    this.library = library;
  }


  /**
   * Returns {@link #name}.
   *
   * @return {@link #name}.
   */
  public String getName()
  {
    return name;
  }


  /**
   * Sets {@link #name}.
   *
   * @param name
   */
  public void setName(String name)
  {
    this.name = name;
  }


  /**
   * Returns string representation of this script model.
   *
   * @return String representation of this script model.
   */
  @Override
  public String toString()
  {
    return String.format("Script { library=%s, name=%s }", library, name);
  }

}

