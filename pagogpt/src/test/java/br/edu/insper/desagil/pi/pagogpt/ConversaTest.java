package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversaTest {

    @Test
    void subTotalVazio(){
        Conversa c = new Conversa(new Usuario("laisa@gmail", "laisa"));
        assertEquals(0, c.calculaSubTotal());
    }

    @Test
    void subTotal(){
        Conversa c = new Conversa(new Usuario("laisa@gmail", "laisa"));

        /* Tres prompts e adiciona na lista: */
        PromptGratuito p1 = new PromptGratuito("pergunta", 10);
        PromptPago p2 = new PromptPago("pergunta", 0.1);
        PromptPago p3 = new PromptPago("pergunta", 0.01);

        c.adiciona(p1);
        c.adiciona(p2);
        c.adiciona(p3);

        assertEquals((0 + 0.8 + 0.08), c.calculaSubTotal(), 0.01);

    }

    @Test
    void porPostVazio(){
        Conversa c = new Conversa(new Usuario("laisa@gmail", "laisa"));

        Exception ex = assertThrows(IllegalStateException.class, () -> { c.calculaSubMedia(); } );
        assertEquals("Nenhum prompt!", ex.getMessage());
    }

    @Test
    void porPost(){
        Conversa c = new Conversa(new Usuario("laisa@gmail", "laisa"));

        /* Tres prompts e adiciona na lista: */
        PromptGratuito p1 = new PromptGratuito("pergunta", 10);
        PromptPago p2 = new PromptPago("pergunta", 0.1);
        PromptPago p3 = new PromptPago("pergunta", 0.01);

        c.adiciona(p1);
        c.adiciona(p2);
        c.adiciona(p3);

        assertEquals((0 + 0.8 + 0.08)/3, c.calculaSubMedia(), 0.01);
    }

}