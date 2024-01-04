package com.pedrosiccha.tipocambioapi.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TipoCambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;

    public TipoCambioEntity() {
    }

    public TipoCambioEntity(String monedaOrigen, String monedaDestino, double tipoCambio) {
        this.monedaOrigen = Objects.requireNonNull(monedaOrigen, "Moneda de origen no puede ser nula");
        this.monedaDestino = Objects.requireNonNull(monedaDestino, "Moneda de destino no puede ser nula");
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
        if (!(o instanceof TipoCambioEntity that)) return false;
        return Double.compare(that.getTipoCambio(), getTipoCambio()) == 0 && getId().equals(that.getId()) && getMonedaOrigen().equals(that.getMonedaOrigen()) && getMonedaDestino().equals(that.getMonedaDestino());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMonedaOrigen(), getMonedaDestino(), getTipoCambio());
    }
}
