package com.ecommerce.suncionfabrizio.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(
        name = "Producto.buscarPorNombre",
        query = "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))"),
    @NamedQuery(
        name = "Producto.buscarPorCategoria",
        query = "SELECT p FROM Producto p WHERE p.categoria = :categoria"),
    @NamedQuery(
        name = "Producto.stockBajo",
        query = "SELECT p FROM Producto p WHERE p.stock < :minimo")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String categoria;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;

    @Column(length = 100)
    private String marca;

    @Column(name = "codigo_barras", length = 50, unique = true)
    private String codigoBarras;
}