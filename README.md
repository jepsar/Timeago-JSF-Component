# Timeago JSF Component

JSF 2.2 component for the [Timeago jQuery plugin](https://github.com/rmm5t/jquery-timeago) (that makes it easy to
support automatically updating fuzzy timestamps (e.g. "4 minutes ago"). Timestamps are updated at the client side, which
save round trips to the server (reducing server load and saving bandwidth).

The current version is 1.0 and is bundled with Timeago 1.5.4.

## Usage

Add this dependency to your `pom.xml`:

````xml
<dependency>
  <groupId>com.github.jepsar</groupId>
  <artifactId>timeago-jsf</artifactId>
  <version>1.0</version>
</dependency>
````

In your XHTML files add the following namespace:

````xml
xmlns:ta="http://jepsar.org/timeago"
````

Now you can use the component by passing a `java.util.Date` using the `value` attribute:

````xml
<ta:timeAgo value="#{bean.date}" />
````

## jQuery / JSF component library integration

The component will take care of loading jQuery. It tries to integrate with JSF component libraries that also rely on
jQuery, so you won't end up with multiple / conflicting jQuery versions.

Supported JSF component libraries at this moment:

* PrimeFaces
* BootsFaces

If you are not using one of these libraries, it will load the bundled version of jQuery.

## Localization

The component will try to load a [localization script](./tree/master/src/main/resources/META-INF/resources/jepsar/locale)
based on the JSF `UIViewRoot#getLocale()`.

You can simply set it, for example to Dutch, in your XHTML like:

````xml
<f:view locale="nl">
  ...
</f:view>
````
