package com.pedrosiccha.tipocambioapi.infrastructure.persistence;

import java.util.Optional;

public interface TipoCambioRepositoryCustom {
    Optional<TipoCambioEntity> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
