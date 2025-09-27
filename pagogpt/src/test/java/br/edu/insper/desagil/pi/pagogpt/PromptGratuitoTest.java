package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptGratuitoTest {

    @Test
    void precoCurto(){
        PromptGratuito p = new PromptGratuito("pergunta", 10);
        assertEquals(0, p.calculaPreco());
    }

    @Test
    void precoLongo(){
        PromptGratuito p = new PromptGratuito("pergunta longa", 10);
        assertEquals(14, p.calculaPreco());
    }

}
