package br.edu.insper.desagil.pi.pagogpt;

import java.util.List;

public class Cobrador {

    /* Atributos:*/
    private List<Conversa> conversas;

    /* Construtor:*/
    public Cobrador(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    /* Metodo calculaTotal:*/
    public double calculaTotal(Usuario usuario){
        double soma = 0;
        String email = usuario.getEmail();

        for(Conversa conversa : conversas){
            if(conversa.getUsuario().getEmail().equals(email)){
                soma += conversa.calculaSubTotal();
            }
        }
        return soma;
    }
}
