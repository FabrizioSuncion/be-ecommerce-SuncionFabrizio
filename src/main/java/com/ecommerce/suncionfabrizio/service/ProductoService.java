package com.ecommerce.suncionfabrizio.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.suncionfabrizio.dto.ProductoDTO;
import com.ecommerce.suncionfabrizio.entity.Producto;
import com.ecommerce.suncionfabrizio.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> listar() {
        return productoRepository.findAll().stream().map(this::toDTO).toList();
    }

    public ProductoDTO obtenerPorId(Long id) {
        return toDTO(buscar(id));
    }

    public List<ProductoDTO> buscarPorNombre(String nombre) {
        return productoRepository.buscarPorNombre(nombre).stream().map(this::toDTO).toList();
    }

    public ProductoDTO crear(ProductoDTO dto) {
        Producto producto = toEntity(dto);
        producto.setId(null);
        return toDTO(productoRepository.save(producto));
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto producto = buscar(id);
        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setMarca(dto.getMarca());
        producto.setCodigoBarras(dto.getCodigoBarras());
        return toDTO(productoRepository.save(producto));
    }

    public void eliminar(Long id) {
        productoRepository.delete(buscar(id));
    }

    private Producto buscar(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producto no encontrado con id " + id));
    }

    private ProductoDTO toDTO(Producto p) {
        return new ProductoDTO(p.getId(), p.getNombre(), p.getCategoria(),
                p.getPrecio(), p.getStock(), p.getMarca(), p.getCodigoBarras());
    }

    private Producto toEntity(ProductoDTO d) {
        return new Producto(d.getId(), d.getNombre(), d.getCategoria(),
                d.getPrecio(), d.getStock(), d.getMarca(), d.getCodigoBarras());
    }
}