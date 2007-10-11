/*
 * QueryOntology.java
 *
 * Created on 10 de Outubro de 2007, 20:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package grow.semanticweb.query;

import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.RDFObject;
import edu.stanford.smi.protegex.owl.model.query.QueryResults;
import grow.semanticweb.infra.ontology.OntologyConnection;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ig Bittencourt
 */
public class QueryOntology {
    
    private OWLModel            owlModel;
    private OntologyConnection ontologyConnection;
    
    /** Creates a new instance of QueryOntology */
    public QueryOntology(final String owlFile) {
        this.ontologyConnection = OntologyConnection.getInstance(owlFile);
        this.owlModel = this.ontologyConnection.getOwlModel();
    }
    
    public QueryOntology(final URI owlURI) {
        this.ontologyConnection = OntologyConnection.getInstance(owlURI);
        this.owlModel = this.ontologyConnection.getOwlModel();
    }
    
    private String defaultExecution(String subject, String predicate,
            String object) throws Exception {
        
        if ( (subject == null && predicate == null && object == null )
        || ( subject != null && predicate != null && object != null )){
            try {
                throw new Exception("Invalid Configuration");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        String queryString = null;
        
        String auxSubject   = "";
        String auxPredicate = "";
        String auxObject    = "";
        
        if ( subject == null ){
            auxSubject = " ?subject ";
            subject = auxSubject;
        }
        
        if ( predicate == null ){
            auxPredicate = " ?predicate ";
            predicate = auxPredicate;
        }
        
        if ( object == null ){
            auxObject = " ?object ";
            object = auxObject;
        }
        
        queryString = "SELECT " + auxSubject + auxPredicate + auxObject +
                "  WHERE { " + subject + predicate + object + " }";
        
        return queryString;
    }
    
    public Map retrieve(String subject, String predicate,
            String object) throws Exception {
        
        if ( (subject == null && predicate == null && object == null )
        || ( subject != null && predicate != null && object != null )){
            try {
                throw new Exception("Invalid Configuration");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        String queryString = null;
        
        String auxSubject   = "";
        String auxPredicate = "";
        String auxObject    = "";
        
        if ( subject == null ){
            auxSubject = " ?subject ";
            subject = auxSubject;
        }
        
        if ( predicate == null ){
            auxPredicate = " ?predicate ";
            predicate = auxPredicate;
        }
        
        if ( object == null ){
            auxObject = " ?object ";
            object = auxObject;
        }
        
        queryString = "SELECT " + auxSubject + auxPredicate + auxObject +
                "  WHERE { " + subject + predicate + object + " }";
        
        Map map = new HashMap();
        
        QueryResults qr = this.owlModel.executeSPARQLQuery(queryString);
        
        int i = 0;
        
        while (qr.hasNext()){
            i++;
            Map aux = qr.next();
            map.put(i,aux.get("subject"));
        }
        
        return map;
    }
    
    public Map retrieve(String query) throws Exception {
        
        if (query == null){
            try {
                throw new Exception("Invalid Configuration");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        String queryString = query;
        
        QueryResults qr = null;
        Map<Integer, RDFObject> map = new HashMap();
        
        try {
            qr = this.owlModel.executeSPARQLQuery(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        int i = 0;
        
        while (qr.hasNext()){
            i++;
            Map aux = qr.next();
            map.put(i, ( (RDFObject) aux.get("subject") ) );
        }

        return map;
    }
    
}
