package com.pedrosiccha.tipocambioapi.application;

import com.pedrosiccha.tipocambioapi.domain.model.TipoCambio;
import com.pedrosiccha.tipocambioapi.domain.service.TipoCambioNotFoundException;
import com.pedrosiccha.tipocambioapi.domain.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {
    private final TipoCambioService tipoCambioService;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @PostMapping("/realizar-cambio")
    public ResponseEntity<Object> realizarCambio(@RequestBody TipoCambioRequest request) {
        try {
            TipoCambio tipoCambio = tipoCambioService.realizarCambio(request).block();
            return ResponseEntity.ok(tipoCambio);
        } catch (TipoCambioNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TipoCambio>> buscarPorId(@PathVariable Long id) {
        return tipoCambioService.buscarPorId(id)
                .map(tipoCambio -> ResponseEntity.ok(tipoCambio))
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorResume(error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TipoCambio())));
    }

}
