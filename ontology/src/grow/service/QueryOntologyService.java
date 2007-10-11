package grow.service;

import edu.stanford.smi.protegex.owl.model.RDFObject;
import grow.semanticweb.query.QueryOntology;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ig Bittencourt
 */
public class QueryOntologyService {
    
    private QueryOntology queryOntology;
    
    public String retrieveByFileQ(String owlFile, String query) {
        Map<Integer, RDFObject> map = new HashMap<Integer, RDFObject>();

        queryOntology = new QueryOntology(owlFile);

        try {
            map = queryOntology.retrieve(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        StringBuilder stringBuilder = new StringBuilder();        
        
        for (RDFObject rdfObject : map.values()) {
        	stringBuilder.append("'")
        		.append(rdfObject.toString())
        		.append("' ");    	
        }

        return stringBuilder.toString();
    }
//    
//    public String[] retrieveByURIQ(URI owlURI, String query) {
//        Map<Integer, RDFObject> map = new HashMap<Integer, RDFObject>();
//        queryOntology = new QueryOntology(owlURI);
//        try {
//            map = queryOntology.retrieve(query);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        String[] valores = new String[map.size()];
//        
//        int i = -1;
//        for (RDFObject rdfObject : map.values()) {
//        	valores[++i] = rdfObject.toString();    	
//        }
//
//        return valores;
//    }
//    
//    public String[] retrieveByFileTrip(String owlFile, String subject, String predicate,
//            String object) throws Exception {
//        Map<Integer, RDFObject> map = new HashMap<Integer, RDFObject>();
//        queryOntology = new QueryOntology(owlFile);
//        try {
//            map = queryOntology.retrieve(subject, predicate, object);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        String[] valores = new String[map.size()];
//        
//        int i = -1;
//        for (RDFObject rdfObject : map.values()) {
//        	valores[++i] = rdfObject.toString();    	
//        }
//
//        return valores;
//    }
//    
//    public String[] retrieveByURITrip(URI owlURI, String subject, String predicate,
//            String object) throws Exception {
//        Map<Integer, RDFObject> map = new HashMap<Integer, RDFObject>();
//        queryOntology = new QueryOntology(owlURI);
//        try {
//            map = queryOntology.retrieve(subject, predicate, object);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        String[] valores = new String[map.size()];
//        
//        int i = -1;
//        for (RDFObject rdfObject : map.values()) {
//        	valores[++i] = rdfObject.toString();    	
//        }
//
//        return valores;
//    }
    
    public static void main(String[] args) {
    	QueryOntologyService q = new QueryOntologyService();
//    	Object[] ob = q.retrieveByFileQ("c:/ProjetoPesquisaOntology.pprj",
//				"SELECT ?subject WHERE { :Instituicao_1 :cnpj ?subject  }");
    	String ob = q.retrieveByFileQ(
	    	"c:/GrOW.pprj",
			"SELECT ?subject WHERE { :Projeto_GrOW j.0:palavras-chave ?object . " +
			"?object j.0:termo ?subject" +
			"}");
    	
    	System.out.println(ob.toString());
	}
    
}
