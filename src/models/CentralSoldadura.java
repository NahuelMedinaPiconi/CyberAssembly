package models;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CentralSoldadura {
    
    private Semaphore sem;
    private Integer[] espais;

    public CentralSoldadura(int maxEntrys, int espais) {
        this.sem = new Semaphore(maxEntrys);
        this.espais = new Integer[espais];
    }

    public int soldar() {
        Random random = new Random();
        int bateriaPerduda = random.nextInt(10);
        try {
            sem.acquire();
            int espaiOcupat = _ocuparEspai();
            Thread.sleep(random.nextLong(100));
            espais[espaiOcupat] = 0;
            sem.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bateriaPerduda;
    }

    private synchronized Integer _ocuparEspai() {
        for (int i = 0; i < espais.length; i++) {
            if (espais[i] == 0) {
                espais[i] = 1;
                return i;
            }
        }
        return null;
    }
}
