public class TelevisionViewer {
    public static void main(String[] args) {
        Television_task_1 myTV = new Television_task_1();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.clickOnorOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.clickOnorOff();

            System.out.println("Falling asleep");
        }
    }
}