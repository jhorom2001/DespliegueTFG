package dam2.TFG.Film24.modelo;

import java.util.List;

public class PedidoDTO {
    private int id;
    private String fechaFormateada;
    private double total;
    private String estado; 
    private List<LineaPedidoDTO> lineas;

    public PedidoDTO(int id, String fechaFormateada, double total, String estado, List<LineaPedidoDTO> lineas) {
        this.id = id;
        this.fechaFormateada = fechaFormateada;
        this.total = total;
        this.estado = estado;
        this.lineas = lineas;
    }

    public int getId() {
        return id;
    }

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public List<LineaPedidoDTO> getLineas() {
        return lineas;
    }
}
