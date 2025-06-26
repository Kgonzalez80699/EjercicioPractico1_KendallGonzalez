package ejerciciopractico1.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import ejerciciopractico1.demo.domain.Factura;
import ejerciciopractico1.demo.domain.Producto;

@Entity
@Table(name = "factura_detalle") // .
public class FacturaDetalle implements Serializable {

    // Necesario para la serialización de objetos (especialmente en entornos distribuidos).
    private static final long serialVersionUID = 1L;

    @Id // Marca este campo como la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID será generado automáticamente por la BD.
    private Long id; // ID único para cada detalle de factura.

    // Relación Many-to-One con la entidad Factura.
    // Muchos detalles de factura pueden pertenecer a una sola factura.
    @ManyToOne // Define la relación.
    @JoinColumn(name = "id_factura", nullable = false) // Mapea la columna de la clave foránea en la tabla 'factura_detalle'.
    // 'nullable = false' indica que un detalle de factura siempre debe estar asociado a una factura.
    private Factura factura; // Referencia a la entidad Factura a la que pertenece este detalle.

    // Relación Many-to-One con la entidad Producto.
    // Muchos detalles de factura pueden referenciar al mismo producto.
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false) // Cantidad del producto vendido.
    private Integer cantidad; // Usamos Integer para permitir nulls si fuera necesario, pero aquí es 'nullable = false'.

    @Column(name = "precio_unitario", nullable = false) // Precio del producto en el momento de la venta.
    private Double precioUnitario; // Podrías usar BigDecimal para mayor precisión en cálculos monetarios.

    @Column(name = "subtotal") // Calculado: cantidad * precioUnitario.
    private Double subtotal; // Usar BigDecimal es más recomendable para dinero.

    // --- Constructores ---
    public FacturaDetalle() {
        // Constructor vacío requerido por JPA.
    }

    // Constructor útil para crear nuevos detalles con los datos esenciales.
    public FacturaDetalle(Factura factura, Producto producto, Integer cantidad, Double precioUnitario) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        // Calcula el subtotal al crear el objeto.
        this.subtotal = (precioUnitario != null && cantidad != null) ? (precioUnitario * cantidad) : 0.0;
    }

    // --- Getters y Setters ---
    // (Estos métodos permiten acceder y modificar los atributos de la entidad)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        // Recalcular subtotal si la cantidad cambia.
        calcularSubtotal();
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
        // Recalcular subtotal si el precio unitario cambia.
        calcularSubtotal();
    }

    public Double getSubtotal() {
        return subtotal;
    }

    // El subtotal se calcula, no se establece directamente desde fuera.
    // private para que solo se pueda calcular internamente o por el constructor.
    private void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    // Método auxiliar para calcular el subtotal.
    @PrePersist // Se ejecuta antes de persistir la entidad.
    @PreUpdate // Se ejecuta antes de actualizar la entidad.
    public void calcularSubtotal() {
        if (this.precioUnitario != null && this.cantidad != null) {
            this.subtotal = this.precioUnitario * this.cantidad;
        } else {
            this.subtotal = 0.0;
        }
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" +
                "id=" + id +
                ", facturaId=" + (factura != null ? factura.getId() : "null") +
                ", productoId=" + (producto != null ? producto.getId() : "null") +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}
