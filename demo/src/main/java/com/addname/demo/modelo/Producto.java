package com.addname.demo.modelo;

import javax.persistence.*;
import java.math.BigInteger;

@Table(name = "productos")
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 60,nullable = false)
    private String nombre;

    @Column(name = "codigo",length = 60,nullable = false )
    private Long codigo;

    @Column(name = "stock",nullable = false)
    private Long stock;

    @Column(name = "precioIva",nullable = false)
    private Long precioIva;

    //constructor
    public Producto() {

    }
//g and s
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(Long precioIva) {
        this.precioIva = precioIva;
    }
}
