package com.pedrosiccha.tipocambioapi.application;

import java.util.Objects;

public class TipoCambioRequest {

    private String monedaOrigen;
    private String monedaDestino;
    private double monto;

    public TipoCambioRequest() {
    }

    public TipoCambioRequest(String monedaOrigen, String monedaDestino, double monto) {
        this.monedaOrigen = Objects.requireNonNull(monedaOrigen, "Moneda de origen no puede ser nula");
        this.monedaDestino = Objects.requireNonNull(monedaDestino, "Moneda de destino no puede ser nula");
        this.monto = monto;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
