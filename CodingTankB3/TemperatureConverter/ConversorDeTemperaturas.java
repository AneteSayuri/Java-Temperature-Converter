package CodingTankB3.TemperatureConverter;

import java.util.Scanner;

public class ConversorDeTemperaturas {
    public static void main(String[] args) {
        initialize();
        UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saída");
        double tempI = getTempI();
        double tempF;
        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToCelsius transformToCelsius = new ToCelsius();
        ToKelvin transformToKelvin = new ToKelvin();

        switch (unityOutput) {
            case CELSIUS:
                tempF = transformToCelsius.transform(unityInput, tempI);
                break;
            case KELVIN:
                tempF = transformToKelvin.transform(unityInput, tempI);
                break;
            case FAHRENHEIT:
                tempF = transformToFahrenheit.transform(unityInput, tempI);
                break;
            default:
                tempF = 0;
                break;
        }

        System.out.println("O resultado da conversão de " + tempI + unityInput
                + " é " + tempF + unityOutput + ".");
    }

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas.");
    }

    private static UnityTemp getUnityTemp(String entradaOuSaida) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a unidade de temperatura de " + entradaOuSaida);
        String typeString = input.nextLine().toUpperCase();
        return UnityTemp.valueOf(typeString);
    }

    private static double getTempI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a temperatura original: ");
        return input.nextDouble();
    }

}
