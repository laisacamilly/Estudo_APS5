package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PromptPagoTest {

    @Test
    void constroi(){
        PromptPago pg = new PromptPago("pergunta", 0.1);
        assertSame("pergunta", pg.getPergunta());
        assertNull(null, pg.getResposta());
    }

    @Test
    void mudaResposta(){
        PromptPago pg = new PromptPago("pergunta", 0.1);
        pg.setResposta("resposta");
        assertEquals("resposta", pg.getResposta());
    }

    @Test
    void preco(){
        PromptPago pg = new PromptPago("pergunta", 0.1);
        assertEquals(0.8, pg.calculaPreco(), 0.01);
    }
}
