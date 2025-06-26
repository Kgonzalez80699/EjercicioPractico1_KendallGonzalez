/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopractico1.demo.domain;
import jakarta.persistence.*; // O javax.persistence si usas versiones antiguas de Spring Boot
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "queja")
public class Queja implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Coincide con el 'Long' en JpaRepository

    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private String estado;
    
    public Queja() {
    }
    
    public Queja(String titulo, String descripcion, LocalDateTime fechaCreacion, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Queja{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                // Agrega el cliente si la relación está activa
                // ", clienteId=" + (cliente != null ? cliente.getId() : "null") +
                '}';
    }
}
