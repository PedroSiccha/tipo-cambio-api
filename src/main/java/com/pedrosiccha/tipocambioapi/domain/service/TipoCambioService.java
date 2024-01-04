package com.pedrosiccha.tipocambioapi.domain.service;

import com.pedrosiccha.tipocambioapi.domain.model.TipoCambio;
import com.pedrosiccha.tipocambioapi.application.TipoCambioRequest;
import reactor.core.publisher.Mono;

public interface TipoCambioService {
    Mono<TipoCambio> realizarCambio(TipoCambioRequest request);

    Mono<TipoCambio> buscarPorId(Long id);

}
