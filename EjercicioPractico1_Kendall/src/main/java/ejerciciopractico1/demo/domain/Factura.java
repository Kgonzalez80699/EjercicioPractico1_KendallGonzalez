package ejerciciopractico1.demo.domain;
import jakarta.persistence.*; // O javax.persistence si usas versiones antiguas de Spring Boot
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "factura")

public class Factura implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O GenerationType.AUTO, etc.
    private Long id; // Este ID coincide con el 'Long' en JpaRepository
    private String descripcion;
    private LocalDateTime fechaCreacion;
    // Otros atributos de la factura

    public Factura() {
    }

    public Factura(String descripcion, LocalDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
