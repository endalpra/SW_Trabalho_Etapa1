package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Érico
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="compra")
public class Compra implements Serializable{
    @XmlElement(required = true)
    @Id
    @SequenceGenerator(name="seq_compra", sequenceName = "seq_compra_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_compra", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @XmlElement(required = true)
    @Column(name = "c_nome", length = 40, nullable = false)
    @NotBlank(message="O nome do cliente deve ser informado")
    private String c_nome;
    @XmlElement(required = true)
    @Column(name = "c_endereco", length = 40, nullable = false)
    @NotBlank(message="O endereço do cliente deve ser informado")
    private String c_endereco;
    @XmlElement(required = true)
    @Column(name="valor_compra", nullable = false)
    @NotNull(message="O valor da compra deve ser informado")
    private Double valor_compra;
    @XmlElement(required = true)
    @Column(name="cep_origem", length = 40, nullable = false)
    @NotBlank(message="O cep de origem deve ser informado")
    private String cep_origem;
    @XmlElement(required = true)
    @Column(name="cep_destino", length = 40, nullable = false)
    @NotBlank(message="O cep de destino deve ser informado")
    private String cep_destino;
    @XmlElement(required = true)
    @Column(name="valor_frete", nullable = false)
    @NotNull(message="O valor do frete deve ser informado")
    private Double valor_frete;
    @XmlElement(required = true)
    @Column(name="prazo_entrega", nullable = false)
    @NotNull(message="O prazo de entrega deve ser informado")
    private Integer prazo_entrega;

    public Compra(){        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getC_nome() {
        return c_nome;
    }

    public void setC_nome(String c_nome) {
        this.c_nome = c_nome;
    }

    public String getC_endereco() {
        return c_endereco;
    }

    public void setC_endereco(String c_endereco) {
        this.c_endereco = c_endereco;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public String getCep_origem() {
        return cep_origem;
    }

    public void setCep_origem(String cep_origem) {
        this.cep_origem = cep_origem;
    }

    public String getCep_destino() {
        return cep_destino;
    }

    public void setCep_destino(String cep_destino) {
        this.cep_destino = cep_destino;
    }

    public Double getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(Double valor_frete) {
        this.valor_frete = valor_frete;
    }

    public Integer getPrazo_entrega() {
        return prazo_entrega;
    }

    public void setPrazo_entrega(Integer prazo_entrega) {
        this.prazo_entrega = prazo_entrega;
    }    
}
