package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaProxyTest {

    @BeforeEach
    void setUp() {
        Database.addPessoa(new Pessoa(1, 1, "Danilo", "Vassouras", false));
        Database.addPessoa(new Pessoa(2, 2, "Roberto", "Vassouras", false));
    }

    @Test
    void deveRetornarDadosPessoa() {
        PessoaProxy pessoa = new PessoaProxy(1);

        assertEquals(Arrays.asList("Danilo", "Vassouras"), pessoa.obterDados());
    }

    @Test
    void deveRetornarDocumentosPessoa() {
        Pessoa pessoaFuncionario = new Pessoa(3, 3, "João", "Vassouras", true);
        PessoaProxy pessoa = new PessoaProxy(2);

        assertEquals(Arrays.asList(2, 2), pessoa.obterDocumentos(pessoaFuncionario));
    }

    @Test
    void deveRetornarExcecaoPessoaNaoAutorizadoConsultarDocumentosPessoa() {
        try {
            Pessoa pessoaFuncionario = new Pessoa(3, 3, "João", "Vassouras", false);
            PessoaProxy pessoa = new PessoaProxy(2);

            pessoa.obterDocumentos(pessoaFuncionario);
            fail();
        }catch (IllegalArgumentException e) {
            assertEquals("Está pessoa não é um funcionario", e.getMessage());
        }
    }
}
