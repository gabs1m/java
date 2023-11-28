package model;

public class Funcionario extends Pessoa{
    private String contaBancaria;
    private int codigoFuncionario;
    private boolean permissaoAdmin = false;
    
    public Funcionario(String nome, String cpf, int idade, String sexo, String endereco, String telefone, String contaBancaria){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setSexo(sexo);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setContaBancaria(contaBancaria);
    }
    public Funcionario(){}
    
    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setPermissaoAdmin(boolean permissaoAdmin) {
        this.permissaoAdmin = permissaoAdmin;
    }
    public boolean getPermissaoAdmin(){
        return this.permissaoAdmin;
    }
}
