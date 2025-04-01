package com.example.facvet.model;
import java.util.List;

public class Factura {
    private Long id;
    private String cliente;
    private List<ServicioVeterinario> servicios;
    private double total;

    public Factura(Long id, String cliente, List<ServicioVeterinario> servicios) {
        this.id = id;
        this.cliente = cliente;
        this.servicios = servicios;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return servicios.stream().mapToDouble(ServicioVeterinario::getCosto).sum();
    }

    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public List<ServicioVeterinario> getServicios() { return servicios; }
    public double getTotal() { return total; }

    public void setId(Long id) { this.id = id; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setServicios(List<ServicioVeterinario> servicios) {
        this.servicios = servicios;
        this.total = calcularTotal();
    }
}
