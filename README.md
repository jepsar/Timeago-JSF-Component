# Timeago JSF Component

JSF component for the [Timeago jQuery plugin](https://github.com/rmm5t/jquery-timeago). This component will load
jQuery, the timeago plugin and optionally a localization script.

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

````
xmlns:ta="http://jepsar.org/timeago"
````

Now you can use the component by passing a `java.util.Date` using the `value` attribute:

````
<ta:timeAgo value="#{bean.date}" />
````

## jQuery / JSF component library integration

The component will take care of loading jQuery. It tries to integrate with JSF component libraries that also rely on
jQuery, so you won't end up with multiple / conflicting jQuery versions.

Supported JSF component libraries at this moment:

* PrimeFaces
* BootsFaces

## Localization

The component will try to load a localization script based on the JSF `UIViewRoot#getLocale()`.
