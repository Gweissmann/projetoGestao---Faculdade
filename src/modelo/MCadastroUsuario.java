/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Bruno
 */
public class MCadastroUsuario {
    private String nome = "";
    private String email = "";
    private String senha  = "";
    private String confirmasenha = "";
    private double salariomensal = 0.00;
    private double rendaextra = 0.00;
    

     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmasenha() {
        return confirmasenha;
    }

    public void setConfirmasenha(String confirmasenha) {
        this.confirmasenha = confirmasenha;
    }
    
    public void setSalarioMensal(double salariomensal){
        this.salariomensal = salariomensal;
    }
    
    public double getSalarioMensal(){
        return salariomensal;
    }
    
    public void setRendaExtra(double rendaextra){
        this.rendaextra = rendaextra;
    }
    
    public double getRendaExtra(){
        return rendaextra;
    }
    
    
}
