package com.example.practicahilosprioridad;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Hilos extends Thread {

    ProgressBar progressBar;
    Slider prioridadHilos;
    double porcentaje;

    Label labelPorcentaje;

    public Hilos(ProgressBar progressBar, Slider prioridadHilos, Label labelPorcentaje) {
        this.progressBar = progressBar;
        this.prioridadHilos = prioridadHilos;
        this.labelPorcentaje = labelPorcentaje;
        porcentaje = 0;
        System.out.println("[ CREANDO HILO ]: " + getName());
    }
    public void run() {
        while (porcentaje < 1.0) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    labelPorcentaje.setText((int)1 + "");
                    labelPorcentaje.setText((int)(porcentaje*100) + "");
                }
            });

            progressBar.setProgress(porcentaje);
            primosHasta(50000);
            porcentaje += 0.01;
        }
    }

    public void primosHasta(int hasta) {
        for (int i = 0; i < hasta; i++) {
            if(esPrimo(i)){
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
