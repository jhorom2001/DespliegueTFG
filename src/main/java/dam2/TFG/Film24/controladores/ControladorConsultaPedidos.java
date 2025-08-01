package dam2.TFG.Film24.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dam2.TFG.Film24.dao.Film24DAO;
import dam2.TFG.Film24.modelo.LineaPedidoDTO;
import dam2.TFG.Film24.modelo.PedidoDTO;
import dam2.TFG.Film24.modelo.Usuario;
import jakarta.servlet.http.HttpSession;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControladorConsultaPedidos {

    @Autowired
    private Film24DAO dao;

    @GetMapping("/listaPedidos")
    public String mostrarPedidosUsuario(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Mapeamos a PedidoDTO usando tu clase
        List<PedidoDTO> pedidosDTO = usuario.getPedidos().stream().map(p -> {
            List<LineaPedidoDTO> lineasDTO = p.getLineas().stream()
                .map(linea -> new LineaPedidoDTO(
                    linea.getProducto().getNombre(),
                    linea.getCantidad(),
                    linea.getSubtotal(),
                    linea.getProducto().getImagen()))
                .collect(Collectors.toList());

            return new PedidoDTO(
                p.getId(),
                p.getFecha().format(formatter),
                p.getTotal(),
                p.getEstado(),
                lineasDTO
            );
        }).collect(Collectors.toList());

        model.addAttribute("pedidos", pedidosDTO);

        return "listaPedidos";
    }
}
