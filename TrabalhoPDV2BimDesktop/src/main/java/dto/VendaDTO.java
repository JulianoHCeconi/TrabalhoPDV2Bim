package dto;

import java.util.List;

public class VendaDTO {

    private Long clienteId;
    private String observacoes;
    private List<ItemVendaDTO> itens;

    public VendaDTO() {}

    public VendaDTO(Long clienteId, String observacoes, List<ItemVendaDTO> itens) {
        this.clienteId = clienteId;
        this.observacoes = observacoes;
        this.itens = itens;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<ItemVendaDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaDTO> itens) {
        this.itens = itens;
    }
}
