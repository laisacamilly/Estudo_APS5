package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversaTest {

    @Test
    void subTotalVazio(){
        Usuario u = new Usuario("laisa@gmail.com", "laisa");
        Conversa c = new Conversa(u);
        assertEquals(0,c.calculaSubTotal());
    }

    @Test
    void subTotal(){
        Usuario u = new Usuario("laisa@gmail.com", "laisa");
        Conversa c = new Conversa(u);

        PromptGratuito p1 = new PromptGratuito("pergunta",10); /* menor q limite então é 0 */
        PromptPago p2 = new PromptPago("pergunta",0.1); /* 0.8 */
        PromptPago p3 = new PromptPago("perguntaa",0.01); /* 0.09 */

        c.adiciona(p1);
        c.adiciona(p2);
        c.adiciona(p3);

        assertEquals( (0 + 0.8 + 0.09), c.calculaSubTotal(), 0.01);

    }

    @Test
    void porPost(){
        Usuario u = new Usuario("laisa@gmail.com", "laisa");
        Conversa c = new Conversa(u);

        PromptGratuito p1 = new PromptGratuito("pergunta",10); /* menor q limite então é 0 */
        PromptPago p2 = new PromptPago("pergunta",0.1); /* 0.8 */
        PromptPago p3 = new PromptPago("perguntaa",0.01); /* 0.09 */

        c.adiciona(p1);
        c.adiciona(p2);
        c.adiciona(p3);

        assertEquals((0 + 0.8 + 0.09)/3, c.calculaSubMedia(), 0.01);
    }

}
