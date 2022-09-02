package CodingTankB3.TemperatureConverter;

public class ToCelsius {
    public double transform (UnityTemp unityI, double tempOriginal) {
        if (unityI == UnityTemp.FAHRENHEIT) {
            return (tempOriginal - 32) / 1.8;
        } else if(unityI == UnityTemp.KELVIN) {
            return tempOriginal - 273.15;
        } else {
            return tempOriginal;
        }
    }
}