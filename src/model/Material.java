package model;

public class Material {
    private String tipo;
    private String descricao;
    private String categoria;
    private String lote;
    private String dataFabricacao;

    private double valorUnitario;
    private int quantidade;
    private int codigoMaterial;

    public Material(String tipo, String descricao, String categoria, String lote, String dataFabricacao, double valorUnitario, int quantidade){
        this.setTipo(tipo);
        this.setDescricao(descricao);
        this.setCategoria(categoria);
        this.setLote(lote);
        this.setDataFabricacao(dataFabricacao);
        this.setValorUnitario(valorUnitario);
        this.setQuantidade(quantidade);
    }
    public Material(){}

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setCodigo(int codigo) {
        this.codigoMaterial = codigo;
    }
    public int getCodigo() {
        return codigoMaterial;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
    public String getLote() {
        return lote;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
}
