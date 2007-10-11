package grow.semanticweb.infra.ontology;
/*-//GEN-BEGIN:copyright
 * ForBILE - Framework for Building Interactive Learning Environments
 * Computing Institute - Federal University of Alagoas - Brazil
 * Group of Otimization of the Web
 *
 * Copyright (C) 2007 Ig Bittencourt (ig.ibert@gmail.com)
 *		      Camila Nunes (camilapbnunes@hotmail.com)
 *	              Marcos Tadeu (zero.ufal@gmail.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *///GEN-END:copyright
import java.net.URI;
import java.util.logging.Logger;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.query.QueryResults;
import java.util.ArrayList;
import java.util.Collection;

/**
 * EMATHEMAKnowledge.java
 *
 * <p>A full description of this class.
 *
 * @see SomeRelatedClass.
 *
 * @author <a href="mailto:ig.ibert@gmail.com">ig</a>.
 * @since 0.1
 * @version 0.1
 *
 */
public class OntologyConnection {
    
    // Constants -----------------------------------------------------
    
    // Attributes ----------------------------------------------------
    
    private Collection          errors;
    private OWLModel            owlModel;
    private Project             project;
    
    // Static --------------------------------------------------------
    
    private static OntologyConnection    instance;
    private static Integer              connection;
    
    private static Logger logger;
    
    static {
        logger = Logger.getLogger(OntologyConnection.class.getName());
    }
    
    // Constructors --------------------------------------------------
    
    /**
     * Creates a new instance of OntologyConnection.
     *
     * @param owlFile The ontology file.
     */
    private OntologyConnection(final String owlFile) {
        this.errors = new ArrayList();
        
        this.project = Project.loadProjectFromFile(owlFile, this.getErrors());
        
        Object o = this.getProject().getKnowledgeBase();
        
        this.owlModel = (OWLModel) this.getProject().getKnowledgeBase();
    }
    
    /**
     * Creates a new instance of OntologyConnection.
     *
     * @param owlURI The ontology file.
     */
    private OntologyConnection(final URI owlURI) {
        this.errors = new ArrayList();
        
        this.project = Project.loadProjectFromURI(owlURI, this.getErrors());
        
        Object o = this.getProject().getKnowledgeBase();
        
        this.owlModel = (OWLModel) this.getProject().getKnowledgeBase();
    }
    
    // Public --------------------------------------------------------
    
    /**
     * Gets the unique instance of the EMATHEMAKnowledge.
     *
     * @param owlFile The ontology file.
     *
     * @return The unique instance of the EMATHEMAKnowledge.
     */
    public static synchronized OntologyConnection getInstance
            (final String owlFile){
        if (instance == null) {
            instance = new OntologyConnection(owlFile);
            connection = 1;
        } else {
            logger.info("Instance already exist");
            connection++;
        }
        return instance;
    }
    
    /**
     * Gets the unique instance of the EMATHEMAKnowledge.
     *
     * @param owlFile The ontology file.
     *
     * @return The unique instance of the EMATHEMAKnowledge.
     */
    public static synchronized OntologyConnection getInstance
            (final URI owlURI){
        if (instance == null) {
            instance = new OntologyConnection(owlURI);
            connection = 1;
        } else {
            logger.info("Instance already exist");
            connection++;
        }
        return instance;
    }
    /**
     * Gets the connection.
     *
     * @return The connection.
     */
    public Integer getConnection() {
        return this.connection;
    }
    
    /**
     * Gets all the errors.
     *
     * @return the errors.
     */
    public Collection getErrors() {
        return errors;
    }
    
    /**
     * Gets the ontology model.
     *
     * @return the ontology model.
     */
    public OWLModel getOwlModel() {
        return owlModel;
    }
    
    /**
     * Gets the project.
     *
     * @return The project.
     */
    public Project getProject() {
        return project;
    }
       
    // Z implementation ----------------------------------------------
    
    // Y overrides ---------------------------------------------------
    
    // Package protected ---------------------------------------------
    
    // Protected -----------------------------------------------------
    
    // Private -------------------------------------------------------
    
    // Inner classes -------------------------------------------------
    
}
