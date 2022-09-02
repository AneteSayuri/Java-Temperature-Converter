package CodingTankB3.TemperatureConverter;

public class ToFahrenheit {
        public double transform(UnityTemp unityI, double tempOriginal) {
            if (unityI == UnityTemp.CELSIUS) {
                return tempOriginal * 9.0 / 5 + 32;
            } else if (unityI == UnityTemp.KELVIN) {
                return (tempOriginal - 273.15) * 9.0 / 5 + 32;
            } else {
                return tempOriginal;
            }
        }
}
