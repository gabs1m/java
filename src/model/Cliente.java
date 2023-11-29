package model;

public class Cliente extends Pessoa{
    private int codigoCliente;

    public Cliente(String nome, String cpf, String sexo, String endereco, String telefone, int idade){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setIdade(idade);
    }
    public Cliente(){}

    public void setCodigoCliente(int codigo) {
        this.codigoCliente = codigo;
    }
    public int getCodigoCliente() {
        return codigoCliente;
    }

}
