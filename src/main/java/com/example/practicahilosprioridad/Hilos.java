package com.example.practicahilosprioridad;

import javafx.scene.control.ProgressBar;

public class Hilos extends Thread {

    ProgressBar progressBar;

    public Hilos(ProgressBar progressBar) {
        this.progressBar = progressBar;
        System.out.println("[ CREANDO HILO ]: " + getName());
    }
    double porcentaje = 0;

    public void run() {
        while (porcentaje < 1.0) {
            progressBar.setProgress(porcentaje);
            for(int i = 1; i < 100; i++) {
                for (int p = 1; p <= 1000; p++) {
                    if (esPrimo(p) == true) {
                        porcentaje = porcentaje + 0.01;
                    }
                }
            }
        }
    }

    public static boolean esPrimo(int numero){
        for (int i=2; i<numero; i++) {
            if(numero%i==0) {
                return false;
            }
        }
        return true;
    }
}
