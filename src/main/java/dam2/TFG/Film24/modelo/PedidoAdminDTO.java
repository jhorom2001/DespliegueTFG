package dam2.TFG.Film24.modelo;

import java.util.List;

public class PedidoAdminDTO extends PedidoDTO {

    private String usuarioNombre;

    public PedidoAdminDTO(int id, String fechaFormateada, double total, String estado, List<LineaPedidoDTO> lineas, String usuarioNombre) {
        super(id, fechaFormateada, total, estado, lineas);
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

}

