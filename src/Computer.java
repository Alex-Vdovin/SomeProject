public class Computer {
    public int processingTime; // Время выполнения задания
    public int totalProcessingTime;
    public int queue;
    public int downTime;
    public int timeInQueue;
    public boolean isBusy;
    public boolean isWorking;
    public int totalRequests;

    Computer() {
        this.processingTime = 0;
        this.totalProcessingTime = 0;
        this.queue = 0;
        this.downTime = 0;
        this.timeInQueue = 0;
        this.isBusy = false;
        isWorking = true;
        this.totalRequests = 0;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getTotalProcessingTime() {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime(int totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getDownTime() {
        return downTime;
    }

    public void setDownTime(int downTime) {
        this.downTime = downTime;
    }

    public int getTimeInQueue() {
        return timeInQueue;
    }

    public void setTimeInQueue(int timeInQueue) {
        this.timeInQueue = timeInQueue;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }
}
