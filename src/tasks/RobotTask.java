package tasks;

import models.CentralSoldadura;

public class RobotTask implements Runnable {

    CentralSoldadura central;

    public RobotTask(CentralSoldadura central) {
        this.central = central;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            central.soldar();
        }
    }
}
