package com.pedrosiccha.tipocambioapi.infrastructure.persistence;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class TipoCambioRepositoryImpl implements TipoCambioRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public TipoCambioRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<TipoCambioEntity> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino) {
        // Lógica personalizada para buscar un tipo de cambio por monedas de origen y destino
        // Usa el EntityManager para realizar consultas personalizadas

        // Ejemplo de consulta JPQL
        return Optional.ofNullable(entityManager.createQuery(
                        "SELECT t FROM TipoCambioEntity t WHERE t.monedaOrigen = :monedaOrigen AND t.monedaDestino = :monedaDestino",
                        TipoCambioEntity.class)
                .setParameter("monedaOrigen", monedaOrigen)
                .setParameter("monedaDestino", monedaDestino)
                .getSingleResult());
    }

}
