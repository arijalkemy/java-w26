package org.example.tiendadeprendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tiendadeprendas.model.Prenda;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDto {
    String id;
    LocalDate fecha;
    String medioPago;
    Double precioTotal;
    List<Prenda> prendaLista;
}
