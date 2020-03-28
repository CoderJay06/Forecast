import java.io.*;

public class Forecast {
    // Weather attributes
    private double temperature = 72.0;
    private String skyCondition = "clear";
    private int chanceOfRain = 0;

    // Default constructor
    public Forecast() {

    }

    // Overloaded constructor
    public Forecast(double fTemp, String fSkyCondition,
                    int fChanceOfRain) {
        temperature = fTemp;
        skyCondition = fSkyCondition;
        chanceOfRain = fChanceOfRain;
    }

    // setter method for temperature
    public void setTemp(double newTemp) {
        // from -100.0 through 150.0 degrees Fahrenheit
        if (newTemp >= -100.0 && newTemp <= 150.0) {
            temperature = newTemp;
        }
    }

    // getter method for temperature
    public double getTemperature() {
        return temperature;
    }

    // setter method for sky condition
    public void setSkyCondition(String newSkyCondition) {
        skyCondition = newSkyCondition;
    }

    // getter method for sky condition
    public String getSkyCondition() {
        return skyCondition;
    }

    // setter method for chance of rain
    public void setChanceOfRain(int newChanceOfRain) {
        if (newChanceOfRain >= 0 && newChanceOfRain <= 100) {
            chanceOfRain = newChanceOfRain;
        }
    }

    // getter method for chance of rain
    public int getChanceOfRain() {
        return chanceOfRain;
    }

    // method for converting fahrenheit to celcius
    public double convertFahrenheitToCelcius(double fTemp) {
        // (32°F − 32) × 5/9 = 0°C
        double celsius;
        celsius = (fTemp - 32) * 5 / 9;
        return celsius;
    }

    // method for converting celsius to fahrenheit
    public double convertCelsiusToFahrenheit(double cTemp) {
        // (0°C × 9/5) + 32 = 32°F
        double fahrenheit;
        fahrenheit = (cTemp * 9 / 5) + 32;
        return fahrenheit;
    }
    // method for converting fahrenheit to kelvin
    public double convertFahrenheitToKelvin(double fTemp) {
        // (32°F − 32) × 5/9 + 273.15 = 273.15K
        double kelvin;
        kelvin = (fTemp - 32) * 5 / 9 + 273.15;
        return kelvin;
    }
    // method for converting kelvin to fahrenheit
    public double convertKelvinToFahrenheit(double kTemp) {
        // (0K − 273.15) × 9/5 + 32 = -459.7°F
        double fahrenheit;
        fahrenheit = (kTemp - 273.15) * 9 / 5 + 32;
        return fahrenheit;
    }
    // method that determines whether or not it rains
    public boolean determineIfRain() {
        boolean rain;
        rain = chanceOfRain > 0;
        return rain;
    }

    public void forecastWeatherOptions() {
        System.out.println("(Type 0 to exit at anytime)");
        System.out.println("1. Convert Fahrenheit to Celcius");
        System.out.println("2. Convert Celcius to Fahrenheit");
        System.out.println("3. Convert Fahrenheit to Kelvin");
        System.out.println("4. Convert Kelvin to Fahrenheit ");
    }

    public void setTempsAndConditions() {
        System.out.println("(Type 0 to exit at anytime)");
        System.out.println("1. Enter a temperature to set: (-100.0F - 150.0F) ");
        System.out.println("2. Enter a sky condition to set: ");
        System.out.println("3. Set a chance of rain: (0 - 100) ");
        System.out.println("4. Set all three: (temperature, sky condition, chance of rain)");
    }

    public void fileForecastResult(double temp, String condition, int rainChance) {

        try {
            FileWriter forecastFileWriter = new FileWriter("forecast.txt");
            PrintWriter forecastWriter = new PrintWriter(forecastFileWriter);
            forecastWriter.printf("Forecast Results File:\n Temperature: %.1fF\n Sky condition: %s\n Chance of rain: %d",
                    temp, condition, rainChance);
            forecastWriter.close();
        } catch (FileNotFoundException f) {
            System.out.println("Sorry file was not found.");
        } catch (IOException io) {
            System.out.println("I/O Exception error.");
        } catch (Exception e) {
            System.out.println("Sorry there has been an error.");
        }

    }

}