package sample.components;

import javafx.scene.control.ProgressBar;

public class Corredor extends Thread{

    private ProgressBar progressBar;
    public Corredor(String nombre, ProgressBar progressBar){
        super(nombre);
        this.progressBar = progressBar;
        //this.setName(nombre);
    }

    /*@Override
    public void run() {
        super.run();
        System.out.println("Inicia el corredor "+getName());
        for (int i = 1; i <= 5; i++) {
            try {
                sleep((long)(Math.random()*10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Corredor " + getName() + " completó el km "+i);
        }
        System.out.println("Llegó a la meta el corredor " + getName());
    }*/

    @Override
    public void run() {
        super.run();
        double avance = 0;
        while( avance < 1 ){
            avance += Math.random() / 10; // .34/10 = .034
            this.progressBar.setProgress(avance);
            try {
                sleep((long)(Math.random()*5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
