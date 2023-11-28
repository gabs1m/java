package model;

public class Gerente extends Funcionario {
    private String senhaGerencial;

    public Gerente(String nome, String cpf, String sexo, String endereco, String telefone, String contaBancaria, String codigoFuncionario, String senhaGerencial, int idade, boolean permissaoAdmin){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setContaBancaria(contaBancaria);
        this.setCodigoFuncionario(codigoFuncionario);
        this.setSenhaGerencial(senhaGerencial);
        this.setIdade(idade);
        this.setPermissaoAdmin(permissaoAdmin);
    }
    public Gerente(){}

    public void setSenhaGerencial(String senhaGerencial) {
        this.senhaGerencial = senhaGerencial;
    }
    public String getSenhaGerencial() {
        return senhaGerencial;
    }
}