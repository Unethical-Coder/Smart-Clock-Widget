# Smart-Clock-Widget
The "Smart Clock Widget" project aims to develop a Java-based  application for desktops that offers an intuitive and customizable clock  widget with smart features. The widget will be able to display the current  time and date, and users will be able to customize its appearance, such as choosing between different themes, font sizes, and colors
LIBRARIES USED
JavaFX:
JavaFX is a Java-based framework for building desktop and mobile 
applications. It provides a set of libraries and tools for creating rich 
graphical user interfaces (GUIs), as well as for handling media, 
animation, and web content.
JavaFX includes a scene graph API, which allows developers to create a 
hierarchical tree of graphical elements that can be manipulated and 
animated. It also provides a range of pre-built UI controls, such as 
buttons, text fields, and tables, as well as support for building custom 
controls.
JavaFX applications can be run on desktop platforms, such as Windows, 
mac OS, and Linux, as well as on mobile devices, such as Android and 
iOS, using a special version of the framework called JavaFX Mobile.
Features of JavaFX:-
1. Java library
2. Platform Independent
3. FXML
4. Scene Builder
5. Hardware accelerated Graphics pipeline
6. Built-in UI controls
7. CSS Styling
8. Rich set of APIs
9. High-performance

Java Swing:
Java Swing is a GUI (Graphical User Interface) toolkit for Java 
developers, used to create desktop applications with a graphical user 
interface. It was first introduced in the JDK 1.2 release in 1998 and has 
since become one of the most widely used GUI toolkits for Java 
development. 
Swing provides a rich set of UI components, such as buttons, text fields, 
menus, and dialog boxes, as well as support for layout managers, event 
handling, and other features needed for building sophisticated and 
responsive user interfaces. Swing is designed to be platformindependent, and it can run on any platform that supports Java.
Features of Java Swing:-
1. Lightweight components
2. Pluggable look and feel
3. Highly customizable
4. Rich Controls
GSON:
Gson is a Java library developed by Google that is used to convert Java 
Objects into their JSON representation and vice versa. The name "Gson" 
is a combination of "Google" and "JSON". Gson provides methods to 
serialize Java objects to JSON and de-serialize JSON to Java objects.
Using Gson, you can convert complex Java objects containing nested 
objects and arrays into JSON strings and vice versa. Gson also provides 
several options to customize the serialization and deserialization process, 
such as controlling the output format, ignoring specific fields, handling 
null values, and more.

OpenWeatherMap API:
OpenWeatherMap API is a weather data provider that offers a range of 
weather-related data such as current weather conditions, forecasts, 
historical data, and more, for various locations around the world. The 
OpenWeatherMap API can be accessed via HTTP requests and supports 
various data formats including JSON, XML, and HTML.
Using the OpenWeatherMap API, developers can access a wealth of 
weather data, including current weather conditions, temperature, 
humidity, wind speed, and precipitation. The API also provides 
information on sunrise and sunset times, as well as weather alerts and 
advisories.
To use the OpenWeatherMap API, you need to sign up for an API key, 
which is required to access the data. Once you have the API key, you can 
use it to make HTTP requests to the OpenWeatherMap API endpoints 
and receive weather data in the desired format. The API documentation 
provides detailed information on the available endpoints and 
parameters, as well as examples of how to use the API in various 
programming languages.
Label:
A label is a user interface control that displays a short text string or an 
image. It is typically used to provide descriptive text for other user 
interface components or to display status information in an application. 
A label is an instance of the javafx.scene.control.Label class, which 
provides various properties and methods to customize its appearance 
and behaviour. For example, you can set the text displayed by the label 
using the setText() method, change its font size and colour using the 
setFont() and setTextFill() methods respectively, and align the text using 

the setAlignment() method. Overall, labels are an important component 
of JavaFX user interfaces and are frequently used to provide information 
and feedback to the user.
ComboBox:
In JavaFX, a ComboBox is a user interface control that combines a text 
field and a drop-down list of items from which the user can choose. The 
user can either type in a value directly in the text field or select an item 
from the drop-down list.
A ComboBox is an instance of the javafx.scene.control.ComboBox class, 
which provides various properties and methods to customize its 
appearance and behaviour. For example, you can set the items displayed 
in the drop-down list using the setItems() method, add a prompt text to 
the text field using the setPromptText() method, and handle selection 
events using the setOnAction() method. Overall, ComboBoxes are a 
useful component of JavaFX user interfaces and are frequently used to 
allow users to select values from a predefined set of options.
HttpURLConnection is a built-in class that allows you to send 
HTTP/HTTPS requests and receive responses from a server. It is part of 
the Java standard library and is included in the java.net package. 
HttpURLConnection provides a simple and easy-to-use API for 
communicating with HTTP servers, and supports a wide range of HTTP 
methods, such as GET, POST, PUT, and DELETE. You can use it to 
perform tasks such as downloading files, uploading data, and accessing 
web services.

LocalDate and LocalTime are classes that represent date and time values 
without a time zone or offset. They are part of the java.time package, 
which was introduced in Java 8 as part of the Date-Time API. Both 
LocalDate and LocalTime are immutable class, which means that their 
values cannot be changed once they are created. They are often used 
together with other classes in the java.time package, such as 
LocalDateTime and ZonedDateTime, to represent date and time values 
with time zones or offsets.
JsonObject, JsonElement and JsonParser:
In Java, JsonObject, JsonElement, and JsonParser are classes from the 
javax.json package, which provides a lightweight and flexible way to 
process and generate JSON data. Here's a brief overview of each class:
JsonObject: JsonObject represents a JSON object, which is a collection 
of key-value pairs enclosed in curly braces ({ }). You can create a 
JsonObject object using the Json.createObjectBuilder() method, and 
then use its methods to add or retrieve key-value pairs.
JsonElement: JsonElement is an abstract class that represents a JSON 
value, which can be a string, number, object, array, boolean, or null. You 
can create a JsonElement object using the Json.createReader() method, 
and then use its methods to retrieve the JSON value.
JsonParser: JsonParser is a class that provides a streaming API to 
parse JSON data. You can create a JsonParser object using the 
Json.createParser() method, and then use its methods to parse the JSON 
data one token at a time.

HBox and VBox are layout panes that allow you to arrange UI controls 
horizontally or vertically, respectively. Here's a brief overview of each 
layout pane:
HBox: HBox is a layout pane that arranges its child nodes in a 
horizontal row. You can add child nodes to an HBox using its 
getChildren().add() method, and you can set various properties of the 
HBox, such as its spacing and alignment, using its various setter 
methods.
VBox: VBox is a layout pane that arranges its child nodes in a vertical 
column. You can add child nodes to a VBox using its getChildren().add() 
method, and you can set various properties of the VBox, such as its 
spacing and alignment, using its various setter methods.

SYSTEM REQUIREMENTS
Minimum Hardware requirements:
RAM: 8GB 
CPU: Intel core i3 
Display size: 14 inches 
Software requirements:
IDE: IntelliJ IDEA
OS: Windows or Mac
