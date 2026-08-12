package br.com.fiap.mercadoexpress.produto.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProdutoPatchRequest(
        String nome,
        String tipo,
        String setor,
        String tamanho,

        @Positive(message = "preco deve ser maior que zero")
        BigDecimal preco
) {
}
