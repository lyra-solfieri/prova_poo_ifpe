package prova_poo;

public class Conta {

    private String numero_conta;
    private Banco banco;
    private Cliente cliente;
    private double saldo;

    public Conta(String num_conta,Banco banco,Cliente cliente,double saldo){

        
        this.numero_conta = num_conta;
        this.banco = banco;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void depositar(double deposito){
        this.saldo = saldo + deposito;
    }
      
    public String getNum_conta() {
		return numero_conta;
	}

	public void setNum_conta(String numero_conta) {
		this.numero_conta = numero_conta;
	}
    
	public Banco getBanco() {
		return banco;
	}

	public void setNUm_agencia(Banco banco) {
        this.banco = banco;
        
	}
    
    public Cliente getCliente() {
		return cliente;
	}

	public void setNome(Cliente cliente) {
		this.cliente = cliente;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
}