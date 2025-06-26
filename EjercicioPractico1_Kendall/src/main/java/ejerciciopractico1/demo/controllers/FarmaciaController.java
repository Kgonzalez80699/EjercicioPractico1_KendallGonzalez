package ejerciciopractico1.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Necesario para pasar datos a la vista
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Indica que esta clase es un controlador de Spring MVC
public class FarmaciaController {

    // Maneja las peticiones GET a la raíz de la aplicación (http://localhost:78/)
    @GetMapping("/")
    public String paginaInicio(Model model) {
        // Puedes añadir atributos al modelo que Thymeleaf luego usará
        model.addAttribute("nombreFarmacia", "Farmacia Salud y Vida");
        model.addAttribute("mensajeBienvenida", "Tu salud es nuestra prioridad.");
        return "index"; // Esto resuelve a src/main/resources/templates/index.html
    }

    // Maneja las peticiones GET para ver los productos (http://localhost:78/productos)
    @GetMapping("/productos")
    public String listarProductos(Model model) {
        // Aquí en el futuro obtendrías los productos de tu servicio/DAO
        // Por ahora, solo pasamos un mensaje o una lista vacía para probar Thymeleaf
        model.addAttribute("tituloListado", "Listado de Nuestros Productos");
        // model.addAttribute("productos", servicioProducto.getTodosLosProductos()); // Esto vendrá después
        return "productos_listado"; // Resuelve a src/main/resources/templates/productos_listado.html
    }

    // Maneja las peticiones GET para el formulario de quejas (http://localhost:78/quejas-sugerencias)
    @GetMapping("/quejas-sugerencias")
    public String mostrarFormularioQuejas(Model model) {
        model.addAttribute("encabezadoFormulario", "Envíanos tu Queja o Sugerencia");
        return "quejas_sugerencias_form"; // Resuelve a src/main/resources/templates/quejas_sugerencias_form.html
    }
}