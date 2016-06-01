/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author GWEISSMANN
 */
@Entity
@Table(name = "cadastroconta", catalog = "projetogestao", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cadastroconta.findAll", query = "SELECT c FROM Cadastroconta c"),
    @NamedQuery(name = "Cadastroconta.findByIdCadastroConta", query = "SELECT c FROM Cadastroconta c WHERE c.idCadastroConta = :idCadastroConta"),
    @NamedQuery(name = "Cadastroconta.findByTipoTitulo", query = "SELECT c FROM Cadastroconta c WHERE c.tipoTitulo = :tipoTitulo"),
    @NamedQuery(name = "Cadastroconta.findByNome", query = "SELECT c FROM Cadastroconta c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cadastroconta.findByDataCadastro", query = "SELECT c FROM Cadastroconta c WHERE c.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Cadastroconta.findByDataVencimento", query = "SELECT c FROM Cadastroconta c WHERE c.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Cadastroconta.findByNumeroParcelas", query = "SELECT c FROM Cadastroconta c WHERE c.numeroParcelas = :numeroParcelas"),
    @NamedQuery(name = "Cadastroconta.findByValor", query = "SELECT c FROM Cadastroconta c WHERE c.valor = :valor"),
    @NamedQuery(name = "Cadastroconta.findByJuros", query = "SELECT c FROM Cadastroconta c WHERE c.juros = :juros"),
    @NamedQuery(name = "Cadastroconta.findByIdCliente", query = "SELECT c FROM Cadastroconta c WHERE c.idCliente = :idCliente")})
public class Cadastroconta implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCadastroConta")
    private Integer idCadastroConta;
    @Column(name = "tipoTitulo")
    private String tipoTitulo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "dataCadastro")
    private String dataCadastro;
    @Column(name = "dataVencimento")
    private String dataVencimento;
    @Column(name = "numeroParcelas")
    private Integer numeroParcelas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "juros")
    private Double juros;
    @Column(name = "idCliente")
    private Integer idCliente;

    public Cadastroconta() {
    }

    public Cadastroconta(Integer idCadastroConta) {
        this.idCadastroConta = idCadastroConta;
    }

    public Integer getIdCadastroConta() {
        return idCadastroConta;
    }

    public void setIdCadastroConta(Integer idCadastroConta) {
        Integer oldIdCadastroConta = this.idCadastroConta;
        this.idCadastroConta = idCadastroConta;
        changeSupport.firePropertyChange("idCadastroConta", oldIdCadastroConta, idCadastroConta);
    }

    public String getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(String tipoTitulo) {
        String oldTipoTitulo = this.tipoTitulo;
        this.tipoTitulo = tipoTitulo;
        changeSupport.firePropertyChange("tipoTitulo", oldTipoTitulo, tipoTitulo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        String oldDataCadastro = this.dataCadastro;
        this.dataCadastro = dataCadastro;
        changeSupport.firePropertyChange("dataCadastro", oldDataCadastro, dataCadastro);
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        String oldDataVencimento = this.dataVencimento;
        this.dataVencimento = dataVencimento;
        changeSupport.firePropertyChange("dataVencimento", oldDataVencimento, dataVencimento);
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        Integer oldNumeroParcelas = this.numeroParcelas;
        this.numeroParcelas = numeroParcelas;
        changeSupport.firePropertyChange("numeroParcelas", oldNumeroParcelas, numeroParcelas);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        Double oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        Double oldJuros = this.juros;
        this.juros = juros;
        changeSupport.firePropertyChange("juros", oldJuros, juros);
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        Integer oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCadastroConta != null ? idCadastroConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadastroconta)) {
            return false;
        }
        Cadastroconta other = (Cadastroconta) object;
        if ((this.idCadastroConta == null && other.idCadastroConta != null) || (this.idCadastroConta != null && !this.idCadastroConta.equals(other.idCadastroConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "visao.Cadastroconta[ idCadastroConta=" + idCadastroConta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
