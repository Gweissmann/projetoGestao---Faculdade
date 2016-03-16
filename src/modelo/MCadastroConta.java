
package modelo;


public class MCadastroConta {
    private String nome;
    private String dataCadastro;
    private String dataVencimento;
    private Integer numeroParcelas;
    private Float valor;
    private Float jurosDia;
    private Float jurosMes;
    
    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getJurosDia() {
        return jurosDia;
    }

    public void setJurosDia(Float jurosDia) {
        this.jurosDia = jurosDia;
    }

    public Float getJurosMes() {
        return jurosMes;
    }

    public void setJurosMes(Float jurosMes) {
        this.jurosMes = jurosMes;
    }
    
}
