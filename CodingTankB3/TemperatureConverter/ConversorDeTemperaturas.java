package CodingTankB3.TemperatureConverter;

import java.util.Scanner;

public class ConversorDeTemperaturas {
    public static void main(String[] args) {
        double sumI = 0d;
        double sumF = 0d;
        ToFahrenheit transformToFahrenheit = new ToFahrenheit();
        ToCelsius transformToCelsius = new ToCelsius();
        ToKelvin transformToKelvin = new ToKelvin();

        initialize();
        UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saida");

        int num = getNumTemps();
        if (num > 0) {
            double[] tempI = new double[num];
            double[] tempF = new double[num];

            for (int count = 0; count < num; count++) {
                System.out.print("| Digite a temperatura " + (count + 1) + " de " + num + ", em "
                        + unityInput + ": ");
                tempI[count] = getTempI();

                switch (unityOutput) {
                    case CELSIUS:
                        tempF[count] = transformToCelsius.transform(unityInput, tempI[count]);
                        break;
                    case KELVIN:
                        tempF[count] = transformToKelvin.transform(unityInput, tempI[count]);
                        break;
                    case FAHRENHEIT:
                        tempF[count] = transformToFahrenheit.transform(unityInput, tempI[count]);
                        break;
                }

                sumI += tempI[count];
                sumF += tempF[count];

            }

            System.out.println("|                                                                       |");
            System.out.println("|______________________________Resultados_______________________________|");
            for (int count = 0; count < num; count++) {
                System.out.printf("| " + (count + 1) + ": %.2f " + unityInput
                        + " equivale a %.2f " + unityOutput + ".\n", tempI[count], tempF[count]);
            }
            System.out.printf("| E a media das temperaturas sao de: %.2f " + unityInput
                    + " e %.2f " + unityOutput + ".\n", (sumI / num), (sumF / num));
            System.out.println("|_______________________________________________________________________|");

        } else {
            System.out.println("| Nenhuma temperatura sera convertida, pois Quantidade <= 0.");
            System.out.println("|_______________________________________________________________________|");
        }

    }

    private static void initialize() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|________________Bem-vindo ao conversor de temperaturas!________________|");
        System.out.println("| As unidades de temperatura disponiveis aqui sao:                      |");
        System.out.println("| CELSIUS                                                               |");
        System.out.println("| KELVIN                                                                |");
        System.out.println("| FARENHEIT                                                             |");
        System.out.println("|_______________________________________________________________________|");
    }

    private static UnityTemp getUnityTemp(String entradaOuSaida) {
        Scanner input = new Scanner(System.in);
        System.out.print("| Digite a unidade de temperatura de " + entradaOuSaida + ": ");
        String typeString = input.nextLine().toUpperCase();
        try {
            return UnityTemp.valueOf(typeString);
        } catch (IllegalArgumentException e) {
            System.out.print("| Unidade invalida. Apenas as unidades apresentadas sao validas.\n");
            return getUnityTemp(entradaOuSaida);
        }
    }

    private static int getNumTemps() {
        Scanner input = new Scanner(System.in);
        System.out.print("| Digite a quantidade de temperaturas que deseja transformar: ");
        try {
            return input.nextInt();
        } catch (Exception e) {
            System.out.print("| Erro. Apenas numeros inteiros sao validos.\n");
            return getNumTemps();
        }
    }

    private static double getTempI() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextDouble();
        } catch (Exception e) {
            System.out.print("| Entrada invalida. Sera considerada a temperatura 0,0.\n");
            return 0d;
        }
    }
}
