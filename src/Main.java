import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean currentlyRunning = true;
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);

        forecastAppGreeting();
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            while (currentlyRunning) {
                forecast.setTempsAndConditions();
                userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        forecastEnterTemperature();
                        break;
                    case 2:
                        forecastEnterSkyCondition();
                        break;
                    case 3:
                        forecastEnterChanceOfRain();
                        break;
                    case 4:
                        setAllOfForecast();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        currentlyRunning = false;
                    default:
                        System.out.println("Invalid input please try again...");
                        break;
                }

            }
        }
        else if (userInput == 2) {
            while (currentlyRunning) {
                forecast.forecastWeatherOptions();
                userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        conversionOptionFahrenheitToCelsius();
                        break;
                    case 2:
                        conversionOptionCelsiusToFahrenheit();
                        break;
                    case 3:
                        conversionOptionFahrenheitToKelvin();
                        break;
                    case 4:
                        conversionOptionKelvinToFahrenheit();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        currentlyRunning = false;
                    default:
                        System.out.println("Invalid input please try again...");
                        break;
                }
            }
        }
        else {
            printForecastToFileOption();
        }

    }

    private static void forecastAppGreeting() {
        System.out.println("------------------------------------");
        System.out.println("Welcome to The Weather Forecast App!");
        System.out.println("------------------------------------");
        System.out.println("Type any Forecast menu option:\n'1' to set temperatures and conditions,\n" +
                "'2' to convert temperatures\n" +
                "'3' to print forecast to a file");
    }


    private static void forecastEnterTemperature() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a temperature: ");
        forecast.setTemp(scanner.nextFloat());
        System.out.println("You entered: " + forecast.getTemperature() + "F");
    }

    private static void forecastEnterSkyCondition() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sky condition: ");
        forecast.setSkyCondition(scanner.nextLine());
        System.out.println("You entered: " + forecast.getSkyCondition());
    }

    private static void forecastEnterChanceOfRain() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter chance of rain: ");
        forecast.setChanceOfRain(scanner.nextInt());
        System.out.println("You entered: " + forecast.getChanceOfRain());
    }

    private static void setAllOfForecast() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature: ");
        double inputTemp = scanner.nextFloat();
        System.out.println("Enter sky condition: ");
        scanner.nextLine();
        String inputSkyCondition = scanner.nextLine();
        System.out.println("Enter chance of rain: ");
        int inputChanceOfRain = scanner.nextInt();
        new Forecast(inputTemp, inputSkyCondition, inputChanceOfRain);
        System.out.println("Temperature: " + forecast.getTemperature() + "F, " +
                "Sky Condition: " + forecast.getSkyCondition() + ", Chance of Rain(0-100): "
                + forecast.getChanceOfRain());
    }

    private static void conversionOptionFahrenheitToCelsius() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number to convert: ");
        double convertInput = scanner.nextFloat();
        double newTemp = forecast.convertFahrenheitToCelcius(convertInput);
        System.out.print(convertInput + " Fahrenheit converted To Celcius: ");
        System.out.println(newTemp + "C");
    }

    private static void conversionOptionCelsiusToFahrenheit() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number to convert: ");
        double convertInput = scanner.nextFloat();
        double newTemp = forecast.convertCelsiusToFahrenheit(convertInput);
        System.out.print(convertInput + " Celsius converted to Fahrenheit: ");
        System.out.println(newTemp + "F");
    }

    private static void conversionOptionFahrenheitToKelvin() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal number to convert: ");
        double convertInput = scanner.nextFloat();
        double newTemp = forecast.convertFahrenheitToKelvin(convertInput);
        System.out.println(convertInput + " Fahrenheit converted to Kelvin: ");
        System.out.println(newTemp + "K");
    }

    private static void conversionOptionKelvinToFahrenheit() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal number to convert: ");
        double convertInput = scanner.nextFloat();
        double newTemp = forecast.convertKelvinToFahrenheit(convertInput);
        System.out.println(convertInput + " Kelvin converted to Fahrenheit: ");
        System.out.println(newTemp + "F");
    }

    private static void printForecastToFileOption() {
        Forecast forecast = new Forecast();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature: ");
        double inputTemp = scanner.nextFloat();
        System.out.println("Enter sky condition: ");
        scanner.nextLine();
        String inputSkyCondition = scanner.nextLine();
        System.out.println("Enter chance of rain: ");
        int inputChanceOfRain = scanner.nextInt();
        forecast.fileForecastResult(inputTemp, inputSkyCondition, inputChanceOfRain);
    }

}