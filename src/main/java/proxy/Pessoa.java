package proxy;

import java.util.Arrays;
import java.util.List;

public class Pessoa implements IPessoa {

    private Integer cpf;
    private Integer rg;
    private String nome;
    private String cidade;
    private boolean funcionario;

    public Pessoa(int cpf) {
        this.cpf = cpf;
        Pessoa objeto = Database.getPessoa(cpf);
        this.rg = objeto.rg;
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
    }

    public Pessoa(Integer cpf, Integer rg, String nome, String cidade, boolean funcionario) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.cidade = cidade;
        this.funcionario = funcionario;
    }

    public Integer getCpf() { return cpf; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public boolean isFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) { this.funcionario = funcionario; }

    @Override
    public List<String> obterDados() { return Arrays.asList(this.nome, this.cidade);}

    @Override
    public List<Integer> obterDocumentos(Pessoa pessoa) { return Arrays.asList(this.cpf, this.rg);}

}
