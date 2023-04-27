package proxy;

import java.util.List;

public interface IPessoa {
    List<String> obterDados();

    List<Integer> obterDocumentos(Pessoa pessoa);
}
