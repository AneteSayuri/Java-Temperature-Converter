package CodingTankB3.TemperatureConverter;

public class ToKelvin {
        public double transform(UnityTemp unityI, double tempOriginal) {
            if (unityI == UnityTemp.CELSIUS) {
                return tempOriginal + 273.15;
            } else if (unityI == UnityTemp.FAHRENHEIT) {
                return (tempOriginal - 32.0) * 5.0 / 9 + 273.15;
            } else {
                return tempOriginal;
            }
        }
}
