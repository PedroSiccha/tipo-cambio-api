package com.pedrosiccha.tipocambioapi.application;

import com.pedrosiccha.tipocambioapi.domain.model.TipoCambio;

public class TipoCambioResponse {

    private double montoConvertido;
    private TipoCambio tipoCambio;

    public TipoCambioResponse() {
    }

    public TipoCambioResponse(double montoConvertido, TipoCambio tipoCambio) {
        this.montoConvertido = montoConvertido;
        this.tipoCambio = tipoCambio;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }

    public TipoCambio getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(TipoCambio tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

}
