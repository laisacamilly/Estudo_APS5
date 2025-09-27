package br.edu.insper.desagil.pi.pagogpt;

public abstract class Prompt {

    /* Atributos: */
    private String pergunta;
    private String resposta;

    /* Construtor: --------- */
    public Prompt(String pergunta){
        this.pergunta = pergunta;
        this.resposta = null;
    }

    /* Pergunta pode ser lida: ---------- */
    public String getPergunta() {
        return pergunta;
    }

    /* Resposta pode ser lida e escrita: ------------*/
    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /* Metodo calculaPreco: */
    public abstract double calculaPreco();

}
