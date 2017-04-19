package org.jepsar.timeago.component;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;


/**
 * Render time ago component.
 *
 * @author Jasper de Vries <jepsar@gmail.com>
 */
@FacesRenderer(componentFamily = TimeAgo.COMPONENT_FAMILY, rendererType = TimeAgo.DEFAULT_RENDERER)
public class TimeAgoRenderer extends Renderer
{

  /**
   * ISO 8601 date pattern.
   */
  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";


  /**
   * Render time element and JavaScript.
   *
   * @param context
   * @param component
   *
   * @throws IOException
   */
  @Override
  public void encodeEnd(FacesContext context, UIComponent component) throws IOException
  {
    if (!component.isRendered()) {
      return;
    }
    TimeAgo timeAgo = (TimeAgo) component;
    SimpleDateFormat sdf = dateFormat();

    ResponseWriter writer = context.getResponseWriter();
    writer.startElement("time", timeAgo);
    writer.writeAttribute("id", timeAgo.getClientId(), null);
    writer.writeAttribute("class", "timeago", null);
    writer.writeAttribute("datetime", sdf.format(timeAgo.getValue()), null);
    writer.writeText(sdf.format(timeAgo.getValue()), null);
    writer.endElement("time");

    writer.startElement("script", null);
    writer.writeAttribute("type", "text/javascript", null);
    writer.writeText(String.format("timeagoInit(\"#%s\")", jsId(timeAgo.getClientId())), null);
    writer.endElement("script");
  }


  /**
   * Returns ISO 8601 date formatter.
   *
   * @return ISO 8601 date formatter.
   */
  private SimpleDateFormat dateFormat()
  {
    TimeZone tz = TimeZone.getTimeZone("UTC");
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    sdf.setTimeZone(tz);
    return sdf;
  }


  /**
   * Returns JavaScript version of client ID.
   *
   * @param clientId
   *
   * @return JavaScript version of client ID.
   */
  private String jsId(String clientId)
  {
    return clientId.replace(":", "\\\\:");
  }

}

