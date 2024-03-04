public class Main {
    private static final int TASKS_AMOUNT = 1000;
    private static final int REPEATING_AMOUNT = 100;

    public static void main(String[] args) {
        double[] allAvgProcessingTime1 = new double[100];
        double[] allAvgProcessingTime2 = new double[100];
        double[] allAvgQueueTime1 = new double[100];
        double[] allAvgQueueTime2 = new double[100];
        double[] allAvgDowntime1 = new double[100];
        double[] allAvgDowntime2 = new double[100];

        for (int i = 0; i < REPEATING_AMOUNT; i++) {
            Computer computer1 = new Computer();
            Computer computer2 = new Computer();
            int remainingTasks = TASKS_AMOUNT;
            int simulationTime = 0;
            int requestTime = 0;

            while (computer1.isBusy || computer2.isBusy || remainingTasks != 0) {
                if (!computer1.isBusy) {
                    computer1.isBusy = true;
                    requestTime += generateRequestTime();

                    computer1.processingTime = generateProcessingTime();
                    computer1.totalRequests++;
                    if (computer1.queue > 0) {
                        computer1.queue--;
                    }
                } else if (!computer2.isBusy) {
                    computer2.isBusy = true;
                    requestTime += generateRequestTime();
                    computer2.processingTime = generateProcessingTime();
                    computer2.totalRequests++;
                    if (computer2.queue > 0) {
                        computer2.queue--;
                    }
                } else {
                    if (computer1.queue < computer2.queue) {
                        computer1.queue++;
                    } else {
                        computer2.queue++;
                    }
                }
                if(remainingTasks > 0){
                    remainingTasks--;
                }
                if (computer1.queue != 0) {
                    computer1.timeInQueue++;
                }
                computer1.processingTime--;
                computer1.totalProcessingTime++;
                if (computer1.processingTime == 0) {    //завершил работу
                    computer1.isBusy = false;
                }

                if (computer2.isBusy) {
                    if (computer2.queue != 0) {
                        computer2.timeInQueue++;
                    }
                    computer2.processingTime--;
                    computer2.totalProcessingTime++;
                    if (computer2.processingTime == 0) {    //завершил работу
                        computer2.isBusy = false;
                    }
                }
                if(!computer1.isBusy){
                    computer1.downTime++;
                } else if (!computer2.isBusy) {
                    computer2.downTime++;
                }
                simulationTime++;
            }
            double avgProcessingTime1 = (double) computer1.totalProcessingTime / computer1.totalRequests;
            double avgProcessingTime2 = (double) computer2.totalProcessingTime / computer2.totalRequests;
            double avgQueueTime1 = (double) computer1.timeInQueue / computer1.totalRequests;
            double avgQueueTime2 = (double) computer2.timeInQueue / computer2.totalRequests;
            double avgDowntime1 = (double) computer1.downTime / simulationTime;
            double avgDowntime2 = (double) computer2.downTime / simulationTime;

            allAvgProcessingTime1[i] = avgProcessingTime1;
            allAvgProcessingTime2[i] = avgProcessingTime2;
            allAvgQueueTime1[i] = avgQueueTime1;
            allAvgQueueTime2[i] = avgQueueTime2;
            allAvgDowntime1[i] = avgDowntime1;
            allAvgDowntime2[i] = avgDowntime2;
        }

        double totalAvgProcessingTime1 = 0;
        double totalAvgProcessingTime2 = 0;
        double totalAvgQueueTime1 = 0;
        double totalAvgQueueTime2 = 0;
        double totalAvgDowntime1 = 0;
        double totalAvgDowntime2 = 0;

        for (int i = 0; i < REPEATING_AMOUNT; i++) {
            totalAvgProcessingTime1 += allAvgProcessingTime1[i];
            totalAvgProcessingTime2 += allAvgProcessingTime2[i];
            totalAvgQueueTime1 += allAvgQueueTime1[i];
            totalAvgQueueTime2 += allAvgQueueTime2[i];
            totalAvgDowntime1 += allAvgDowntime1[i];
            totalAvgDowntime2 += allAvgDowntime2[i];
        }
        totalAvgProcessingTime1 /= REPEATING_AMOUNT;
        totalAvgProcessingTime2 /= REPEATING_AMOUNT;
        totalAvgQueueTime1 /= REPEATING_AMOUNT;
        totalAvgQueueTime2 /= REPEATING_AMOUNT;
        totalAvgDowntime1 /= REPEATING_AMOUNT;
        totalAvgDowntime2 /= REPEATING_AMOUNT;

        System.out.println("Компьютер 1: ");
        System.out.println("Среднее время выполнения: " + totalAvgProcessingTime1);
        System.out.println("Среднее время ожидания в очереди: " + totalAvgQueueTime1);
        System.out.println("Средняя вероятность простоя: " + totalAvgDowntime1);
        System.out.println("\nКомпьютер 2: ");
        System.out.println("Среднее время выполнения: " + totalAvgProcessingTime2);
        System.out.println("Среднее время ожидания в очереди: " + totalAvgQueueTime2);
        System.out.println("Средняя вероятность простоя: " + totalAvgDowntime2);
    }

    public static int generateRequestTime() {
        return (int) (Math.random() * 10 + 1);
    }

    public static int generateProcessingTime() {
        return (int) (Math.random() * 19 + 1);
    }
}
