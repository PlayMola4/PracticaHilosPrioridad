package com.example.practicahilosprioridad;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class ThreadController {

    @FXML
    private Button btnComenzar;
    @FXML
    private Slider sliderHilo1;
    @FXML
    private ProgressBar progressBarHilo1;
    @FXML
    private Slider sliderHilo2;
    @FXML
    private ProgressBar progressBarHilo2;
    @FXML
    private Slider sliderHilo3;
    @FXML
    private ProgressBar progressBarHilo3;

    @FXML
    private Label labelPrioridadHilo1;
    @FXML
    private Label labelPrioridadHilo2;
    @FXML
    private Label labelPrioridadHilo3;

    @FXML
    private Label contadorProgressBar1;
    @FXML
    private Label contadorProgressBar2;
    @FXML
    private Label contadorProgressBar3;

    Hilos hilo1;
    Hilos hilo2;
    Hilos hilo3;
    int contador = 0;

    //Cuando movamos el slider el valor se va a mostrar en el Label de Prioridad
    final ChangeListener<Number> numberChangeListener = (obs, old, val) -> {
        final int valorRedondo = (int) (Math.floor(val.intValue() / 1.0) * 1.0);
        sliderHilo1.valueProperty().set(valorRedondo);
        labelPrioridadHilo1.setText(Integer.toString(valorRedondo));
    };

    final ChangeListener<Number> numberChangeListener2 = (obs, old, val) -> {
        final int valorRedondo = (int) (Math.floor(val.intValue() / 1.0) * 1.0);
        sliderHilo2.valueProperty().set(valorRedondo);
        labelPrioridadHilo2.setText(Integer.toString(valorRedondo));
    };

    final ChangeListener<Number> numberChangeListener3 = (obs, old, val) -> {
        final int valorRedondo = (int) (Math.floor(val.intValue() / 1.0) * 1.0);
        sliderHilo3.valueProperty().set(valorRedondo);
        labelPrioridadHilo3.setText(Integer.toString(valorRedondo));
    };

    @FXML
    public void btnComenzar(ActionEvent actionEvent) {
        hilo1 = new Hilos(progressBarHilo1);
        hilo2 = new Hilos(progressBarHilo2);
        hilo3 = new Hilos(progressBarHilo3);

        hilo1.setPriority((int) sliderHilo1.getValue());
        hilo2.setPriority((int) sliderHilo2.getValue());
        hilo3.setPriority((int) sliderHilo3.getValue());

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

    @FXML
    public void sliderHilo1(Event event) {
        sliderHilo1.valueProperty().addListener(numberChangeListener);
        //hilo1.setPriority((int) sliderHilo1.getValue());
    }

    @FXML
    public void sliderHilo2(Event event) {
        sliderHilo2.valueProperty().addListener(numberChangeListener2);
        //hilo2.setPriority((int) sliderHilo2.getValue());
    }

    @FXML
    public void sliderHilo3(Event event) {
        sliderHilo3.valueProperty().addListener(numberChangeListener3);
        //hilo3.setPriority((int) sliderHilo3.getValue());
    }
}