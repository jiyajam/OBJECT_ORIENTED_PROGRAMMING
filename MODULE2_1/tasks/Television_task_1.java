public class Television_task_1 {
    private boolean isOn = false;
    private int channel = 1;

    public void clickOnorOff() {
        if (!isOn) {
            isOn = true;
        } else {
            isOn = false;
        }
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int newChannel) {
        if (newChannel > 0) {
            channel = newChannel;
        }
    }
    public boolean isOn() {
        return isOn;
    }
}
