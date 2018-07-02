/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.InputStream;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

/**
 *
 * @author nurulfirdaus
 */
public class TryLD {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

       public static void main(String[] args) {
       org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
       
        
       //Read a file into a model 
       Model model = ModelFactory.createOntologyModel();
       //InputStream in = FileManager.get().open("C:\\Users\\Nurul Firdaus\\Dropbox\\00. Learning [Research]\\06. PROTEGE\\RealEstate.owl");
       InputStream in = FileManager.get().open("/Users/nurulfirdaus/Dropbox/00. Learning [Research]/06. PROTEGE/RealEstate.owl");
       model.read(in,null, "RDF/XML");//RDF/XML -- XML serialization of RDF to representing information in HTML
       
       //bindings are wrapper libraries that bridge two programming 
       //the strategy of federation converts information from multiple sources into a single format and then combines all the information into a single store
       
              String sparqlQueryTwo =
                //SPARQL endpoints -- provide access to large amounts of structured RDF data
               "PREFIX re:<http://www.semanticweb.org/nurulfirdaus/ontologies/2017/11/realestate#>\n" +
               "PREFIX owl:<http://www.w3.org/2002/07/owl#>\n" +
               "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
               "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n" +
               "PREFIX gn:<http://www.geonames.org/ontology#>\n" +
               "PREFIX geo:<http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +   
               "PREFIX spatial:<http://jena.apache.org/spatial#>\n" + 
               "\n" +    
               "SELECT * \n"+ 
               //SELECT -- return a table of results
               //DISTINCT -- yield only one row for one combination of variables and values
               //http://api.geonames.org/findNearbyPOIsOSM?lat=34.7137903&lng=137.7041961&username=nurul_firdaus
               "WHERE { SERVICE <http://linkedgeodata.org/sparql> \n"+ 
               "{SELECT *\n" +
               "WHERE { ?s ?p ?o} limit 10\n" +
               "}"+     
                 //SERVICE is a feature of SPARQL 1.1 that allows an executing query to to make a SPARQL protocol to another SPARQL endpoint */
               "}"; 
             
              
       //Execute the query
       Query query = QueryFactory.create(sparqlQueryTwo);
       
       QueryExecution qe = QueryExecutionFactory.create(query, model);
       ResultSet results = qe.execSelect(); 
       //Formatting a result set into JSON
       //ResultSetFormatter.outputAsJSON(results);
       //ResultSetFormatter.outputAsXML(results);
       //Formatting a result set into standard out
       ResultSetFormatter.out(System.out, results, query);
       while (results.hasNext()){
           QuerySolution querySolution = results.next();
           
       }
       //Dataset dataset = DatasetFactory.create();
    
       /** Producing the result sets
        * SELECT – Return a table of results.
        * CONSTRUCT – Return an RDF graph, based on a template in the query.
        * DESCRIBE – Return an RDF graph, based on what the query processor is configured to return.
        * ASK – Ask a boolean query
        */
          

       }
       
    }
    

               

 






