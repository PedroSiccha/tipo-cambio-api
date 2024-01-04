package com.pedrosiccha.tipocambioapi.domain.repository;

import com.pedrosiccha.tipocambioapi.domain.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

    Optional<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

}
