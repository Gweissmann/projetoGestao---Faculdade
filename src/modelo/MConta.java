package modelo;

public class MConta {

    private String tipoTitulo = "";
    private String nome = "";
    private String dataCadastro = "";
    private String dataVencimento = "";
    private Integer numeroParcelas = 0;
    private double valor = 0.00;
    private double jurosDia = 0.00;
    private double jurosMes = 0.00;
    private Integer idUsuario = null;
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public String getTipoTitulo() {
        return tipoTitulo;
    }
    
    public void setTipoTitulo(String tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }
    
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
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getJurosDia() {
        return jurosDia;
    }
    
    public void setJurosDia(double jurosDia) {
        this.jurosDia = jurosDia;
    }
    
    public double getJurosMes() {
        return jurosMes;
    }
    
    public void setJurosMes(double jurosMes) {
        this.jurosMes = jurosMes;
    }
<<<<<<< HEAD
    //classe que é alimentada antes da inserçao no banco de dados
    public void cadastraConta(String Tipo,String nome,String dataCadastro,String dataVencimento,int numeroParcelas,double valor){
=======

    //metodo que sera alimentado com valores antes de ser enviado para o banco de dados
    public void cadastraConta(String Tipo, String nome, String dataCadastro, String dataVencimento, int numeroParcelas, double valor, double juros) {
>>>>>>> projetoGestao
        setTipoTitulo(tipoTitulo);
        setNome(nome);
        setDataCadastro(dataCadastro);
        setDataVencimento(dataVencimento);
        setNumeroParcelas(numeroParcelas);
        setValor(valor);
        setJurosDia(juros);
    }
    
}
