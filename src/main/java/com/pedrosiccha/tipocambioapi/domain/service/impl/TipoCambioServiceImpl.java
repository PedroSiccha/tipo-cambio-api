package com.pedrosiccha.tipocambioapi.domain.service.impl;

import com.pedrosiccha.tipocambioapi.application.TipoCambioResponse;
import com.pedrosiccha.tipocambioapi.domain.service.TipoCambioNotFoundException;
import com.pedrosiccha.tipocambioapi.domain.service.TipoCambioService;
import com.pedrosiccha.tipocambioapi.domain.model.TipoCambio;
import com.pedrosiccha.tipocambioapi.domain.repository.TipoCambioRepository;
import com.pedrosiccha.tipocambioapi.application.TipoCambioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    private final TipoCambioRepository tipoCambioRepository;

    @Autowired
    public TipoCambioServiceImpl(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    @Override
    public Mono<TipoCambio> realizarCambio(TipoCambioRequest request) {
        // Lógica de negocio para realizar el cambio
        Optional<TipoCambio> tipoCambioOptional = tipoCambioRepository
                .findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(), request.getMonedaDestino());

        if (tipoCambioOptional.isPresent()) {
            TipoCambio tipoCambio = tipoCambioOptional.get();
            double montoConvertido = request.getMonto() * tipoCambio.getTipoCambio();
            return Mono.just(new TipoCambioResponse(montoConvertido, tipoCambio).getTipoCambio());
        } else {
            return Mono.error(new TipoCambioNotFoundException("Tipo de cambio no encontrado"));
        }
    }

    @Override
    public Mono<TipoCambio> buscarPorId(Long id) {
        return Mono.justOrEmpty(tipoCambioRepository.findById(id));
    }
}
