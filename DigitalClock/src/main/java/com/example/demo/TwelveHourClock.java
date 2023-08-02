package com.example.demo;

import java.io.IOException;
import java.net.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


// Imports for Positioning
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import javafx.scene.image.Image;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class TwelveHourClock extends Application {

    private static final String API_KEY = "4075f3e343447058679a573d9bf5c1ef";
    private static String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Phagwara&appid=" + API_KEY + "&units=metric";
    private static String CITY_NAME = "Select a city";

    private Label timeLabel;
    private Label dayLabel;
    private Label weatherLabel;
    private Label cityLabel;

    @Override
    public void start(Stage primaryStage) throws IOException {


        // Create labels to display the time, day, and weather
        timeLabel = new Label();
        timeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 100));
        timeLabel.setStyle("-fx-font-family: Verdana, sans-serif;");

        dayLabel = new Label();
        dayLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, 30));
        dayLabel.setStyle("-fx-font-family: Verdana, sans-serif;");

        weatherLabel = new Label();
        weatherLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, 20));
        weatherLabel.setStyle("-fx-font-family: Verdana, sans-serif;");

        cityLabel = new Label();
        cityLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, 20));
        cityLabel.setStyle("-fx-font-family: Verdana, sans-serif;");
        cityLabel.setText("City: ");

        ComboBox<String> cityComboBox = new ComboBox<>();

        // Adding CSS properties
        cityComboBox.setPrefWidth(200);
        cityComboBox.setPrefHeight(40);
        cityComboBox.setStyle("-fx-border-width: 0; -fx-border-color: transparent;");
        cityComboBox.setOpacity(0.5);

        // Adding options to the list
        cityComboBox.getItems().addAll("Phagwara", "Patiala", "Chanderi", "Keelakarai", "Vellore", "Thang", "Zaidpur", "West Bengal", "Uravakonda");
        cityComboBox.setValue(CITY_NAME);
        cityComboBox.setOnAction(event -> {
            CITY_NAME = cityComboBox.getValue();
            API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + CITY_NAME + "&appid=" + API_KEY + "&units=metric";


            // Make an HTTP GET request to the OpenWeatherMap API endpoint for the selected city
            try {
                URL url = new URL(API_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Read the response from the API
                Scanner scanner = new Scanner(connection.getInputStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();

                // Parse the JSON response using Gson
                JsonParser parser = new JsonParser();
                JsonObject obj = parser.parse(response).getAsJsonObject();
                JsonObject main = obj.getAsJsonObject("main");
                JsonElement tempElement = main.get("temp");
                JsonElement humidityElement = main.get("humidity");
                JsonElement seaLevel = main.get("sea_level");
                JsonElement groundLevel = main.get("grnd_level");
                JsonElement descElement = obj.getAsJsonArray("weather").get(0).getAsJsonObject().get("description");
                String temp = tempElement.getAsString();
                String desc = descElement.getAsString();
                String humd = humidityElement.getAsString();

                // Fetching Sunset and Sunrise
                JsonParser sun = new JsonParser();
                JsonObject object = parser.parse(response).getAsJsonObject();
                JsonElement sysElement = obj.getAsJsonObject("sys");
                JsonElement sunriseElement = ((JsonObject) sysElement).get("sunrise");
                JsonElement sunsetElement = ((JsonObject) sysElement).get("sunset");
                    long sunriseTimestamp = sunriseElement.getAsLong();
                    long sunsetTimestamp = sunsetElement.getAsLong();
                    Instant sunriseInstant = Instant.ofEpochSecond(sunriseTimestamp);
                    Instant sunsetInstant = Instant.ofEpochSecond(sunsetTimestamp);
                    LocalTime sunriseTime = LocalDateTime.ofInstant(sunriseInstant, ZoneId.systemDefault()).toLocalTime();
                    LocalTime sunsetTime = LocalDateTime.ofInstant(sunsetInstant, ZoneId.systemDefault()).toLocalTime();





                // Set the weather label to display the temperature and description
                weatherLabel.setText("Temperature: " + temp + "°C\n\n" +"Description: "  + desc + "\n\nHumidity: " + humd + "\n\nSunrise: " + sunriseTime + "\n\nSunset: " + sunsetTime + "\n\nSea Level: " + seaLevel + "\n\nGround Level: " + groundLevel);

                // Update the city label
                cityLabel.setText("City: ");

            } catch (IOException e) {
                weatherLabel.setText("Error loading weather");
            }
        });



        // Set initial values for the day and weather labels
        dayLabel.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("d MMMM uuuu")));
        weatherLabel.setText("Loading...");

        // Make an HTTP GET request to the OpenWeatherMap API endpoint for City
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response from the API
        Scanner scanner = new Scanner(connection.getInputStream());
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        // Parse the JSON response using Gson
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(response).getAsJsonObject();
        JsonObject main = obj.getAsJsonObject("main");
        JsonElement tempElement = main.get("temp");
        JsonElement descElement = obj.getAsJsonArray("weather").get(0).getAsJsonObject().get("description");

        String temp = tempElement.getAsString();
        String desc = descElement.getAsString();



        // Create a timeline to update the time label every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime time = LocalTime.now();
            String timeStr;
            if (time.getHour() < 12) {
                timeStr = time.format(DateTimeFormatter.ofPattern("h:mm")) + " AM";
            } else {
                int hour = time.getHour() - 12;
                timeStr = time.format(DateTimeFormatter.ofPattern("h:mm")) + " PM";
            }
            timeLabel.setText(timeStr);

            // Update the day label every minute
            if (time.getSecond() == 0) {
                LocalDate date = LocalDate.now();
                String dayStr = date.getDayOfMonth() + " " + date.getMonth().toString() + " " + date.getYear();
                dayLabel.setText(dayStr);
                //  String currentDay = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
                // currentDayLabel.setText(currentDay);
            }

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Load the images
        Image morningImg = new Image("file:/C:/Users/Saurabh/IdeaProjects/DigitalClock/src/main/java/com/example/demo/images/morning.jpg");
        Image afternoonImg = new Image("file:/C:/Users/Saurabh/IdeaProjects/DigitalClock/src/main/java/com/example/demo/images/afternoon.jpg");
        Image nightImg = new Image("file:/C:/Users/Saurabh/IdeaProjects/DigitalClock/src/main/java/com/example/demo/images/night.jpg");


        // Create a VBox to hold the labels and center them
        HBox hbox = new HBox(10, cityLabel, cityComboBox);
        VBox vbox = new VBox(20, timeLabel, dayLabel, weatherLabel, hbox);


        // Changing background according to the time
        int hourHand = LocalTime.now().getHour();
        if (hourHand >= 6 && hourHand < 12) {
            vbox.setStyle("-fx-background-image: url('" + morningImg.getUrl() + "'); -fx-background-size: cover;");

            //    setting the font color with opacity morning
            timeLabel.setTextFill(Color.rgb(255, 255, 255, 0.61));
            dayLabel.setTextFill(Color.rgb(255, 255, 255, 0.61));
            weatherLabel.setTextFill(Color.rgb(255, 255, 255, 0.81));
            cityLabel.setTextFill(Color.rgb(255, 255, 255, 0.81));

//            // setting the font color with opacity for afternoon
//            timeLabel.setTextFill(Color.rgb(120, 81, 169, 0.71));
//            dayLabel.setTextFill(Color.rgb(120, 81, 169, 0.71));
//            weatherLabel.setTextFill(Color.rgb(255, 255, 255, 0.71));
//            cityLabel.setTextFill(Color.rgb(255, 255, 255, 0.71));

//            // setting the font color with opacity night
//            timeLabel.setTextFill(Color.rgb(255, 255, 255, 0.51));
//            dayLabel.setTextFill(Color.rgb(255, 255, 255, 0.51));
//            weatherLabel.setTextFill(Color.rgb(255, 255, 255, 0.51));
//            cityLabel.setTextFill((Color.rgb(255, 255, 255, 0.51)));

        } else if (hourHand >= 12 && hourHand < 18) {
            vbox.setStyle("-fx-background-image: url('" + afternoonImg.getUrl() + "'); -fx-background-size: cover;");

            // setting the font color with opacity for afternoon
            timeLabel.setTextFill(Color.rgb(120, 81, 169, 0.71));
            dayLabel.setTextFill(Color.rgb(120, 81, 169, 0.71));
            weatherLabel.setTextFill(Color.rgb(255, 255, 255, 0.71));
            cityLabel.setTextFill(Color.rgb(255, 255, 255, 0.71));
        } else {
            vbox.setStyle("-fx-background-image: url('" + nightImg.getUrl() + "'); -fx-background-size: cover;");

            // setting the font color with opacity night
            timeLabel.setTextFill(Color.rgb(255, 255, 255, 0.51));
            dayLabel.setTextFill(Color.rgb(255, 255, 255, 0.51));
            weatherLabel.setTextFill(Color.rgb(255, 255, 255, 0.51));
            cityLabel.setTextFill((Color.rgb(255, 255, 255, 0.51)));
        }

        // Create a Scene with the VBox as its root
        Scene scene = new Scene(vbox, 550, 600);

        // Set the Stage's title and icon, and display the Scene
        primaryStage.setTitle("Twelve Hour Clock");
        primaryStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Digital-clock.svg/1200px-Digital-clock.svg.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        Image icon = new Image("file:/C:/Users/Saurabh/IdeaProjects/DigitalClock/src/main/java/com/example/demo/images/icon.png");
        primaryStage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}