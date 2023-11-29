package model;
import java.util.ArrayList;

public class Pedido {
    private int codigoPedido;
    private int codigoCliente;
    private ArrayList<Material> materiais;
    private int[] quantidadeItens;
    private double valorPedido;
    private String dataPedido;
    private String dataEntrega;
    private int codigoRastreio;

    public Pedido(String dataPedido, String dataEntrega, int codigoCliente, ArrayList<Material> materiais, int[] quantidadeItens){
        this.setDataPedido(dataPedido);
        this.setDataEntrega(dataEntrega);
        this.setCodigoCliente(codigoCliente);
        this.setMateriais(materiais);
        this.setQuantidadeItens(quantidadeItens);
    }
    public Pedido(){};

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }
    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setCodigoRastreio(int codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }
    public int getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setMateriais(ArrayList<Material> materiais) {
        this.materiais = materiais;
    }
    public ArrayList<Material> getMateriais() {
        return materiais;
    }

    public void setQuantidadeItens(int[] quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }
    public int[] getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }
    public double getValorPedido() {
        this.somarValorPedido();
        return valorPedido;
    }
    public void somarValorPedido(){
        double soma = 0;
        for(int i = 0; i < this.getMateriais().size(); i++){
            soma += this.getMateriais().get(i).getValorUnitario() * this.getQuantidadeItens()[i];
        }
        this.valorPedido = soma;
    }
}