package ejerciciopractico1.demo.domain;
import jakarta.persistence.*; // O javax.persistence si usas versiones antiguas de Spring Boot
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O GenerationType.AUTO, etc.
    private Long id; // El tipo de ID coincide con el Long en JpaRepository
    private String nombre;
    // Otros atributos de la categoría

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
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
}
