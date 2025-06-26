package ejerciciopractico1.demo.controllers;
import ejerciciopractico1.demo.service.ClienteService;
import ejerciciopractico1.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarFacturas(Model model) {
        model.addAttribute("facturas", facturaService.listarFacturas());
        return "facturas/lista";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalleFactura(@PathVariable("id") Long id, Model model) {
        model.addAttribute("factura", facturaService.obtenerPorId(id));
        model.addAttribute("detalles", facturaService.obtenerDetalleFactura(id));
        return "facturas/detalle";
    }
}
