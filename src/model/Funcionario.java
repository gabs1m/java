package model;

public class Funcionario extends Pessoa{
    private String contaBancaria;
    private String codigoFuncionario;
    private boolean permissaoAdmin;
    
    public Funcionario(String nome, String cpf, String sexo, String endereco, String telefone, String contaBancaria, String codigoFuncionario, int idade, boolean permissaoAdmin){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setContaBancaria(contaBancaria);
        this.setCodigoFuncionario(codigoFuncionario);
        this.setIdade(idade);
        this.setPermissaoAdmin(permissaoAdmin);
    }
    public Funcionario(){}
    
    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setPermissaoAdmin(boolean permissaoAdmin) {
        this.permissaoAdmin = permissaoAdmin;
    }
    public boolean getPermissaoAdmin(){
        return this.permissaoAdmin;
    }
}
