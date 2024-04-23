package org.bootcamp.service.impl;

import org.bootcamp.domain.Cliente;
import org.bootcamp.domain.Localizador;
import org.bootcamp.domain.Reserva;
import org.bootcamp.repository.ClienteRepository;
import org.bootcamp.repository.LocalizadorRepository;
import org.bootcamp.service.LocalizadorService;

import java.util.List;
import java.util.stream.Collectors;

public class LocalizadorServiceImpl implements LocalizadorService {

    private LocalizadorRepository localizadorRepository;
    private ClienteRepository clienteRepository;

    public LocalizadorServiceImpl() {
        localizadorRepository = new LocalizadorRepository();
        clienteRepository = new ClienteRepository();
    }

    @Override
    public void validarDescuento(Localizador localizador) {
        double descuento = 0D;

        if (localizador == null || localizador.getReservas().isEmpty() || localizador.getCliente() == null)
            return;

        Cliente cliente = clienteRepository.buscar(localizador.getCliente().getDni());

        if (cliente.getNombre() == null)
            return;

        List<Localizador> localizadoresCliente = localizadorRepository.obtenerTodos().stream()
                .filter(localizador1 -> localizador1.getCliente() == cliente)
                .collect(Collectors.toList());

        if (localizadoresCliente.size() >= 2)
            descuento += 0.05; // Equivalente al 5%

        int reservasHotel = 0;
        int reservasViaje = 0;
        for (Localizador localizador1 : localizadoresCliente){
            for(Reserva reserva : localizador1.getReservas()){
                if (reserva.isViaje())
                    ++reservasViaje;

                if(reserva.isHotel())
                    ++reservasHotel;
            }
        }

        if(reservasViaje >= 2 && reservasHotel >= 2)
            descuento += 0.05; // Equivalente al 5%

        if (localizador.getReservas().stream().anyMatch(
                reserva -> reserva.isComida() && reserva.isHotel() && reserva.isViaje() && reserva.isTransporte()))
            descuento += 0.1; // equivalente al 10%

        // Se calcula el descuento y se obtiene el valor total
        localizador.setDescuento(localizador.getSubtotal() * descuento);
        localizador.setTotal(localizador.getSubtotal() - localizador.getDescuento());

        localizadorRepository.guardar(localizador);
    }
}
