package br.edu.insper.desagil.pi.pagogpt;

public class PromptGratuito extends Prompt{

    /* Atributos:*/
    private Integer limite;

    /* Construtor: */
    public PromptGratuito(String pergunta, Integer limite) {
        super(pergunta);
        this.limite = limite;
    }

    /* Metodo sobscreve:*/
    @Override
    public double calculaPreco(){
        if (getPergunta().length() < limite){
            return 0;
        }
        else{
            return getPergunta().length();
        }
    }


}
