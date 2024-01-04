package com.pedrosiccha.tipocambioapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;

    public TipoCambio() {
    }

    public TipoCambio(Long id, String monedaOrigen, String monedaDestino, double tipoCambio) {
        this.id = id;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoCambio that)) return false;
        return Double.compare(that.getTipoCambio(), getTipoCambio()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getMonedaOrigen(), that.getMonedaOrigen()) && Objects.equals(getMonedaDestino(), that.getMonedaDestino());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMonedaOrigen(), getMonedaDestino(), getTipoCambio());
    }
}
