package prova_poo;

public class Poupanca extends Conta{
    
    private double juros = 0.5;

    public Poupanca(String num_conta,Banco banco,Cliente cliente,double saldo,double juros){
        super(num_conta, banco, cliente, saldo);
        this.juros = juros;
    }
   public void Render_juros() {
       this.setSaldo(this.getSaldo() + juros);

   }
  
    
}
