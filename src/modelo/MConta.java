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
    
    public String getJdcDataCadastro() {
        return dataCadastro;
    }
    
    public void setJdcDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public String getJdcDataVencimento() {
        return dataVencimento;
    }
    
    public void setJdcDataVencimento(String dataVencimento) {
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

    //metodo que sera alimentado com valores antes de ser enviado para o banco de dados
    public void cadastraConta(String Tipo, String nome, String JdcdataCadastro, String JdcdataVencimento, int numeroParcelas, double valor, double juros) {
        setTipoTitulo(tipoTitulo);
        setNome(nome);
        setJdcDataCadastro(dataCadastro);
        setJdcDataVencimento(dataVencimento);
        setNumeroParcelas(numeroParcelas);
        setValor(valor);
        setJurosDia(juros);
    }
    
}
