package proxy;

import java.util.List;

public class PessoaProxy implements IPessoa{

    private Pessoa pessoa;

    private Integer cpf;

    public PessoaProxy(Integer cpf) { this.cpf = cpf; }

    @Override
    public List<String> obterDados() {
        if (this.pessoa == null) {
            this.pessoa = new Pessoa(this.cpf);
        }
        return this.pessoa.obterDados();
    }

    @Override
    public List<Integer> obterDocumentos(Pessoa pessoa) {
        if (!pessoa.isFuncionario()) {
            throw new IllegalArgumentException("Está pessoa não é um funcionario");
        }
        if (this.pessoa == null) {
            this.pessoa = new Pessoa(this.cpf);
        }
        return this.pessoa.obterDocumentos(pessoa);
    }
}
