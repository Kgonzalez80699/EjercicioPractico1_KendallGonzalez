
package ejerciciopractico1.demo.controllers;
import ejerciciopractico1.demo.domain.Medicamento;
import ejerciciopractico1.demo.service.CategoriaService;
import ejerciciopractico1.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public String listaMedicamentos(Model model){
        model.addAttribute("Medicamentos", medicamentoService.listarmedicamentos());
        return "medicamentos/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "medicamentos/formulario";  // HTML: templates/medicamentos/formulario.html
    }

    // Guardar medicamento (nuevo o editado)
    @PostMapping("/guardar")
    public String guardarMedicamento(@ModelAttribute Medicamento medicamento) {
        medicamentoService.guardarMedicamento(medicamento);
        return "redirect:/medicamentos";
    }

    // Mostrar formulario para editar medicamento
    @GetMapping("/editar/{id}")
    public String editarMedicamento(@PathVariable("id") Long id, Model model) {
        Medicamento medicamento = medicamentoService.obtenerPorId(id);
        model.addAttribute("medicamento", medicamento);
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "medicamentos/formulario";
    }

    // Eliminar medicamento
    @GetMapping("/eliminar/{id}")
    public String eliminarMedicamento(@PathVariable("id") Long id) {
        medicamentoService.eliminarMedicamento(id);
        return "redirect:/medicamentos";
    }
}
