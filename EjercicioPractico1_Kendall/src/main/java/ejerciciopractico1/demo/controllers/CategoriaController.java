package ejerciciopractico1.demo.controllers;
import ejerciciopractico1.demo.domain.Categoria;
import ejerciciopractico1.demo.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "categorias/lista";  // HTML: categorias/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";  // HTML: categorias/formulario.html
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categoria", categoriaService.obtenerPorId(id));
        return "categorias/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}
