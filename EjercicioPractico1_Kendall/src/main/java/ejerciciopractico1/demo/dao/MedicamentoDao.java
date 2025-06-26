package ejerciciopractico1.demo.dao;
import ejerciciopractico1.demo.domain.Medicamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoDao extends JpaRepository<Medicamento, Long> {
    // Buscar medicamentos por nombre que contengan una palabra
    List<Medicamento> findByNombreContainingIgnoreCase(String nombre);

    // Buscar por categoría (si usas relaciones JPA correctamente)
    List<Medicamento> findByCategoriaId(Long idCategoria);
}
