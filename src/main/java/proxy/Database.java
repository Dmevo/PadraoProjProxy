package proxy;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<Integer, Pessoa> pessoas = new HashMap<>();

    public static Pessoa getPessoa(Integer cpf) { return pessoas.get(cpf); }

    public static void addPessoa(Pessoa pessoa) { pessoas.put(pessoa.getCpf(), pessoa); }

}
