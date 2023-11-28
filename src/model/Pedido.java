package model;
import java.util.ArrayList;

public class Pedido {
    private int codigoPedido;
    private String codigoCliente;
    private ArrayList<Material> materiais;
    private int[] quantidadeItens;
    private double valorPedido;
    private String dataPedido;
    private String dataEntrega;
    private int codigoRastreio;

    public Pedido(String dataPedido, String dataEntrega, String codigoCliente, ArrayList<Material> materiais, int[] quantidadeItens){
        this.setDataPedido(dataPedido);
        this.setDataEntrega(dataEntrega);
        this.setCodigoCliente(codigoCliente);
        this.setMateriais(materiais);
        this.setQuantidadeItens(quantidadeItens);

        double soma = 0;
        for(int i = 0; i < materiais.size(); i++){
            soma += materiais.get(i).getValorUnitario();
        }
        this.setValorPedido(soma);
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

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    public String getCodigoCliente() {
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
        return valorPedido;
    }
}