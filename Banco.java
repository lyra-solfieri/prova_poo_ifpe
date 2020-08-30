package prova_poo;

public class Banco {
    private String numero_agencia;
    private String nome_agencia;
    
    public Banco(String n,String nome){
        this.numero_agencia = n;
        this.nome_agencia = nome;
    }

    public String getNum_agencia() {
		return numero_agencia;
	}

	public void setNUm_agencia(String numero_agencia) {
        this.numero_agencia = numero_agencia;
    }

    public String getNome_agencia(){
        return nome_agencia;
    }
    public void setNome_agencia(String nome_agencia){
        this.nome_agencia = nome_agencia;
    }


}