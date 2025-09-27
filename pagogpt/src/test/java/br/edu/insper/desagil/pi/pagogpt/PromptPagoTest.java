package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PromptPagoTest {
    /* Atributos: */
    private PromptPago p;

    @Test
    void constroi(){
        p = new PromptPago("pergunta", 0.1);
        assertEquals("pergunta", p.getPergunta());
        assertNull(p.getResposta());

    }

    @Test
    void mudaResposta(){
        p = new PromptPago("pergunta", 0.1);
        p.setResposta("resposta");
        assertEquals("resposta", p.getResposta());
    }

    @Test
    void preco(){
        p = new PromptPago("pergunta", 0.1);
        assertEquals(0.8, p.calculaPreco(), 0.01);
    }
}
