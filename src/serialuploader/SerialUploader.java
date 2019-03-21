/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialuploader;

import java.sql.Connection;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import service.UploadManagement;


/**
 *
 * @author bachtiar
 */
public class SerialUploader implements Runnable {

    static int interval;
    static Timer timer;
    Connection conn = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Make scheduled programm running
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new SerialUploader();

        task.run();
        int initialDelay = 4;
        int periodicDelay = 60;

        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay, TimeUnit.SECONDS);
    }

    @Override
    public void run() {

        UploadManagement service = new UploadManagement();
        service.checkPendingUpload();
        try {
            for (double progressPercentage = 0.0; progressPercentage < 1.0; progressPercentage += 0.01) {
                runProgress(progressPercentage);
                Thread.sleep(600);
            }
        } catch (InterruptedException e) {
        }
    }

    static void runProgress(double progressPercentage) {
        final int width = 60; // progress bar width in chars

        System.out.print("\r[");
        int i = 0;
        for (; i <= (int) (progressPercentage * width); i++) {
            System.out.print("#");
        }
        for (; i < width; i++) {
            System.out.print(" ");
        }
        System.out.print("]");
    }
}
