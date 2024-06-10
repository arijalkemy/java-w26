package com.mercadolibre.seguro_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiniestroDto {
    private final String marca;
    private final String modelo;
    private final Double perdidaEconomica;

    // Inner Builder Class
    public static class Builder {
        private String marca;
        private String modelo;
        private Double perdidaEconomica;

        // Setter Methods
        public Builder withMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public Builder withModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder withPerdidaEconomica(Double perdidaEconomica) {
            this.perdidaEconomica = perdidaEconomica;
            return this;
        }

        // Build Method
        public SiniestroDto build() {
            return new SiniestroDto(marca, modelo, perdidaEconomica);
        }
    }
}
