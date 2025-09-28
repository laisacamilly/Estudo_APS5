package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CobradorTest {

    @Test
    void nenhumaValida(){
        List<Conversa> conversas = new ArrayList<>();
        Cobrador c = new Cobrador(conversas);
        Usuario u = new Usuario("laisa@gmail", "laisa");

        assertEquals(0, c.calculaTotal(u));
    }

    @Test
    void umaValida(){
        List<Conversa> conversas = new ArrayList<>();
        Cobrador c = new Cobrador(conversas);

        /* Tres conversas e adiciona a lista: */
        Conversa c1 = new Conversa(new Usuario("lara@gmail", "lara"));
        Conversa c2 = new Conversa(new Usuario("joão@gmail", "joão"));
        Conversa c3 = new Conversa(new Usuario("jana@gmail", "jana"));

        conversas.add(c1);
        conversas.add(c2);
        conversas.add(c3);

        /* Prompt pra uma só:*/
        Usuario u = new Usuario("lara@gmail", "lara");
        Conversa con = new Conversa(u);

        PromptGratuito p1 = new PromptGratuito("pergunta", 10);
        con.adiciona(p1);

        assertEquals(0, c.calculaTotal(u));
    }

    @Test
    void duasValida(){
        List<Conversa> conversas = new ArrayList<>();
        Cobrador c = new Cobrador(conversas);

        /* Tres conversas e adiciona a lista: */
        Conversa c1 = new Conversa(new Usuario("lara@gmail", "lara"));
        Conversa c2 = new Conversa(new Usuario("lara@gmail", "lara"));
        Conversa c3 = new Conversa(new Usuario("jana@gmail", "jana"));

        conversas.add(c1);
        conversas.add(c2);
        conversas.add(c3);

        /* Prompt pra duas conversas: */
        Usuario u = new Usuario("lara@gmail", "lara");
        Conversa con = new Conversa(u);

        PromptGratuito p1 = new PromptGratuito("pergunta", 10);
        PromptPago p2 = new PromptPago("pergunta", 0.1);
        con.adiciona(p1);
        con.adiciona(p2);

        assertEquals(0.8, c.calculaTotal(u));

    }
}
