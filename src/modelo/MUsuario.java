/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMUniOp;

/**
 *
 * @author Bruno
 */
public class MUsuario {

    private String nome = "";
    private String email = "";
    private String senha = "";
    private double salariomensal = 0.00;
    private double rendaextra = 0.00;
    private Integer idUsuario = null;

    //Metodo Singleton*******
    private static MUsuario instance = null;

    private MUsuario() {
        // Exists only to defeat instantiation.
    }

    public static MUsuario getInstance() {
        if (instance == null) {
            instance = new MUsuario();
        }
        return instance;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

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

    

    public void setSalarioMensal(double salariomensal) {
        this.salariomensal = salariomensal;
    }

    public double getSalarioMensal() {
        return salariomensal;
    }

    public void setRendaExtra(double rendaextra) {
        this.rendaextra = rendaextra;
    }

    public double getRendaExtra() {
        return rendaextra;
    }

    public boolean loginUsuario(String email, String senha) {
        return false;
    }

    //metodo que sera alimentado com valores antes de ser enviado para o banco de dados
    public void cadastroUsuario(String nome, String email, String senha, double salarioMensal, double rendaExtra) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setSalarioMensal(salarioMensal);
        setRendaExtra(rendaExtra);
    }

    public void getlogin(String email, String senha) {
        setEmail(email);
        setSenha(senha);

    }

}
