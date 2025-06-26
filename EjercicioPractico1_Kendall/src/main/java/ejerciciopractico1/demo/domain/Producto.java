package ejerciciopractico1.demo.domain;

import jakarta.persistence.*; // Usa 'jakarta.persistence.*' para Spring Boot 3+
import java.io.Serializable; // Necesario para que las entidades se puedan serializar

// Esta clase representa un producto en la farmacia.
@Entity // Anota la clase como una entidad JPA, mapeándola a una tabla de base de datos.
@Table(name = "producto") // Opcional: Define explícitamente el nombre de la tabla en la BD.
public class Producto implements Serializable {

    // Necesario para la serialización de objetos (especialmente en entornos distribuidos).
    private static final long serialVersionUID = 1L;

    @Id // Marca este campo como la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID será generado automáticamente por la BD.
    private Long id; // ID único para cada producto.

    @Column(name = "nombre", nullable = false, length = 100) // Nombre del producto.
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT") // Descripción detallada del producto.
    private String descripcion;

    @Column(name = "precio", nullable = false) // Precio de venta del producto.
    private Double precio; // Usar BigDecimal es más recomendable para mayor precisión en dinero.

    @Column(name = "stock", nullable = false) // Cantidad de unidades disponibles en inventario.
    private Integer stock;

    @Column(name = "activo", nullable = false) // Indica si el producto está activo/disponible (true) o no (false).
    private boolean activo; // Usamos 'boolean' para true/false.

    // Relación Many-to-One con la entidad Categoria.
    // Muchos productos pueden pertenecer a una sola categoría.
    @ManyToOne // Define la relación.
    @JoinColumn(name = "id_categoria", nullable = false) // Mapea la columna de la clave foránea en la tabla 'producto'.
    // 'nullable = false' indica que un producto siempre debe estar asociado a una categoría.
    private Categoria categoria; // Referencia a la entidad Categoria a la que pertenece este producto.

    // --- Constructores ---
    public Producto() {
        // Constructor vacío requerido por JPA.
    }

    // Constructor útil para crear nuevos productos con los datos esenciales.
    public Producto(String nombre, String descripcion, Double precio, Integer stock, boolean activo, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.activo = activo;
        this.categoria = categoria;
    }

    // --- Getters y Setters ---
    // (Estos métodos permiten acceder y modificar los atributos de la entidad)

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isActivo() { // Para booleanos, el getter es 'isNombreCampo'
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", activo=" + activo +
                ", categoriaId=" + (categoria != null ? categoria.getId() : "null") + // Muestra solo el ID de la categoría
                '}';
    }
}