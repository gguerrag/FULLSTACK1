package com.example.facvet.controller;

import com.example.facvet.model.Factura;
import com.example.facvet.model.ServicioVeterinario;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/veterinaria")
@CrossOrigin(origins = "*")

public class FacturaVeterinariaController {

    private List<ServicioVeterinario> servicios = Arrays.asList(
        new ServicioVeterinario(1L, "Consulta general", "Revisión médica general", 15000),
        new ServicioVeterinario(2L, "Vacunación", "Vacuna antirrábica", 8000),
        new ServicioVeterinario(3L, "Desparasitación", "Tratamiento antiparasitario", 10000)
    );

    private List<Factura> facturas = Arrays.asList(
        new Factura(1L, "Gonzalo Guerra", List.of(servicios.get(0), servicios.get(1))),
        new Factura(2L, "Alejandro Guerra", List.of(servicios.get(2))),
        new Factura(3L, "Carmen Galdames", List.of(servicios.get(0), servicios.get(2)))
    );

    @GetMapping("/servicios")
    public List<ServicioVeterinario> obtenerServicios() {
        return servicios;
    }

    @GetMapping("/servicios/{id}")
    public ServicioVeterinario obtenerServicioPorId(@PathVariable Long id) {
        return servicios.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/facturas")
    public List<Factura> obtenerFacturas() {
        return facturas;
    }

    @GetMapping("/facturas/{id}")
    public Factura obtenerFacturaPorId(@PathVariable Long id) {
        return facturas.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
