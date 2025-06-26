package ejerciciopractico1.demo.controllers;
import ejerciciopractico1.demo.domain.Queja;
import ejerciciopractico1.demo.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quejas")
public class QuejaController {
    @Autowired
    private QuejaService quejaService;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("queja", new Queja());
        return "quejas/formulario";
    }

    @PostMapping("/enviar")
    public String enviarQueja(@ModelAttribute Queja queja) {
        quejaService.guardarQueja(queja);
        return "redirect:/quejas/formulario?enviado=true";
    }
}
