package com.example.practicahilosprioridad;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Hilos extends Thread {

    ProgressBar progressBar;
    Slider prioridadHilos;
    double porcentaje;

    public Hilos(ProgressBar progressBar, Slider prioridadHilos) {
        this.progressBar = progressBar;
        this.prioridadHilos = prioridadHilos;
        porcentaje = 0;
        System.out.println("[ CREANDO HILO ]: " + getName());
    }
    public void run() {
        while (porcentaje < 1.0) {
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
