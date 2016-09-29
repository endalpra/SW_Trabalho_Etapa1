package br.edu.ifsul.servicos;

import br.edu.ifsul.dao.CompraDAO;
import br.edu.ifsul.modelo.Compra;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Érico
 */
@WebService
public class ServicoCompra implements Serializable{
    @EJB
    private CompraDAO dao;
    
    @WebMethod
    public List<Compra> listaCompras(){
        return dao.getLista();
    }
    
    @WebMethod
    public Compra inserir(@WebParam(name="compra")
    @XmlElement(required=true) Compra objeto){
        Compra obj = null;
        try{
            objeto.setId(null);
            obj = dao.inserir(objeto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
    
    @WebMethod 
    public Compra alterar(@WebParam(name="compra")
        @XmlElement(required=true) Compra objeto){
        Compra obj = null;
        try{
            dao.alterar(objeto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
    
    @WebMethod
    public Boolean remover(@WebParam(name="id")
        @XmlElement(required=true) Integer id){
        return dao.remover(id);
    }
}
