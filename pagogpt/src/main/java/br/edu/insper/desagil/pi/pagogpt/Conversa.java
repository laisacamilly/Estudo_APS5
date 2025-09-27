package br.edu.insper.desagil.pi.pagogpt;

import java.util.ArrayList;
import java.util.List;

public class Conversa {

    /* Atributos: */
    private Usuario usuario;
    private List<Prompt> prompts;

    /* Construtor: ------*/
    public Conversa(Usuario usuario){
        this.usuario = usuario;
        this.prompts= new ArrayList<>();
    }

    /* Usuario pode ser lido e não escrito: -------*/
    public Usuario getUsuario() {
        return usuario;
    }

    /* Metodo adiciona:*/
    public void adiciona(Prompt prompt){
        prompts.add(prompt);
    }

    /* Metodo calculaSubTotal: */
    public double calculaSubTotal(){
        double soma = 0;
        for(Prompt prompt : prompts){
            soma += prompt.calculaPreco();
        }
        return soma;
    }

    /* Metodo calculaSubMedia: */
    public double calculaSubMedia(){
        if (prompts.isEmpty()){
            throw new IllegalStateException("Nenhum prompt!");
        }
        else{
            return (calculaSubTotal() / prompts.size());
            }
        }
}



