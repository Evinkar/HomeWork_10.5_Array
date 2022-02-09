public class main {
    public static int numberOfPatients = 30;

    public static void main(String[] args) {

        generatePatientsTemperatures(numberOfPatients);
        getReport();
    }

    public static float[] generatePatientsTemperatures(int numberOfPatients) {
        double minTemperature = 32.0;
        double maxTemperature = 40.0;
        float[] patientsTemperatures = new float[numberOfPatients];
        for (int i = 0; i < numberOfPatients; i++) {
            double randomTemperature = Math.random() * (maxTemperature - minTemperature) + minTemperature; //Случайное значени в диапазоне от min до max
            patientsTemperatures[i] = (float) randomTemperature;
        }
        return patientsTemperatures;
    }

    public static void getReport() {
        String temperatureList = "";
        float averageTemperature = 0;
        float[] patientsTemperature = generatePatientsTemperatures(numberOfPatients);
        int numberOfHealthPatients = 0;
        int numberOfSickPatients = 0;

        for (int i = 0; i < patientsTemperature.length; i++) {
            temperatureList += patientsTemperature[i] + ", ";
            averageTemperature += patientsTemperature[i];
            boolean isLow = (patientsTemperature[i] < 36.2);
            boolean isHigh = (patientsTemperature[i] > 37.0);
            if (isHigh) {
                numberOfSickPatients++;
            } else if (isLow) {
                numberOfSickPatients++;
            } else {
                numberOfHealthPatients++;
            }

        }
        System.out.println(temperatureList);
        System.out.println("Средняя температура по больнице: " + (averageTemperature / patientsTemperature.length));
        System.out.println("Количество больных пациентов: " + numberOfSickPatients + "\n" + "Количество здоровых пациентов: " + numberOfHealthPatients);
    }
}

