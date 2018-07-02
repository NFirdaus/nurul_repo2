/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
/**
 * Modelling Information -- "It’s not what you think, it’s how you think."
 * @author Nurul Firdaus
 */

import java.io.InputStream;// InputStream - a class is connected to some data source and used for reading the data
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
//Jena calls RDF graphs "models" and triples "statements"
//RDF is semi-structured data
//SPARQL Query has ability to query for data but not to fail query when that data does not exist
import static org.apache.jena.assembler.JA.getURI;
import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.*;
//-------ARQ-Application API---------- class ARQ extends Object
//ARQ can read a query and some data and then run the query on that data
//ARQ is query engine for Jena that supports the SPARQL RDF Query language
import org.apache.jena.query.Query;//Query - a class that represent the application query and it is a container for all the detail of the query
import org.apache.jena.query.QueryFactory;//QueryFactory - a method for creating objects of class Query which provide access to the various parsers
import org.apache.jena.query.QueryExecution;//QueryExecution - represents one execution of a query
import org.apache.jena.query.QueryExecutionFactory;//QueryExecutionFactory - a place to get QueryExecution instances
import org.apache.jena.query.DatasetFactory;//DatasetFactory - a place to make datasets

import org.apache.jena.query.Dataset;
//For SELECT queries
import org.apache.jena.query.QuerySolution;// A single solution to the query
import org.apache.jena.query.ResultSet;// All the QuerySolutions. An iterator.
import org.apache.jena.query.ResultSetFormatter;// turn a ResultSet into various forms
import static org.apache.jena.query.ResultSetFactory.result;

import org.apache.jena.tdb.*;
import org.apache.jena.util.FileManager;


public class ExtractLDPattern extends NewServlet{
    /**
     * @param args the command line arguments
     */
     
       public static void main(String[] args) {
       org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
       
        
       //Read a file into a model 
       Model model = ModelFactory.createOntologyModel();
       //InputStream in = FileManager.get().open("C:\\Users\\Nurul Firdaus\\Dropbox\\00. Learning [Research]\\06. PROTEGE\\RealEstate.owl");
       //InputStream in = FileManager.get().open("C:\\Users\\Nurul Firdaus\\Dropbox\\00. Learning [Research]\\05. DATA\\Transaction-price data\\transaction-price.rdf");
       InputStream in = FileManager.get().open("/Users/nurulfirdaus/Dropbox/00. Learning [Research]/06. PROTEGE/RealEstate.owl");

       model.read(in,null, "RDF/XML");//RDF/XML -- XML serialization of RDF to representing information in HTML
       
       //bindings are wrapper libraries that bridge two programming 
       //the strategy of federation converts information from multiple sources into a single format and then combines all the information into a single store
       
               //Put the query as string
               String sparqlQuery =
                //SPARQL endpoints -- provide access to large amounts of structured RDF data
                //Resources are represented with URIs, which can be abbreviated as prefixed names
               "PREFIX re:<http://www.semanticweb.org/nurulfirdaus/ontologies/2017/11/realestate#>\n" +
               "PREFIX owl:<http://www.w3.org/2002/07/owl#>\n" +
               "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
               "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n" +
               "PREFIX gn:<http://www.geonames.org/ontology#>\n" +
               "PREFIX geo:<http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +   
               "PREFIX spatial:<http://jena.apache.org/spatial#>\n" + 
               "PREFIX fuseki:  <http://jena.apache.org/fuseki#>\n" + 
               "\n" +    
               "select distinct ?c ?p ?y \n"+ 
               /*SELECT followed by a list of the question words
                 DISTINCT eliminates duplicate solutions
               returns variable c, p, y -- picks which data to display*/
                //Query pattern
               "where {\n" + //WHERE indicates the selection pattern -- specifies data to pull out
               "?c ?p ?y. \n" +
               "?c owl:topObjectProperty re:Office . \n"+ 
             /** re:HamamatsuCityHall | owl:topObjectProperty | rdfs:Resource 
               * "?c rdf:type re:Office . \n"+
               * re:Office | rdf:type | rdfs:Class   
               * re:HamamatsuCityHall | rdf:type | rdfs:Resource 
               * "?c rdfs:label ?y. \n"+        
               * | re:HamamatsuStation | rdfs:label | "Train Station"
                 "optional {?c owl:topObjectProperty ?y .}\n"+*/
               //OPTIONAL is to extend the information found in a query solution but to return the non-optional information
               "}"; 
               


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
               "SELECT ?name ?typeClass ?typeName ?lat \n"+ 
               //SELECT -- return a table of results
               //DISTINCT -- yield only one row for one combination of variables and values
               //http://api.geonames.org/findNearbyPOIsOSM?lat=34.7137903&lng=137.7041961&username=nurul_firdaus
               "WHERE {\n" + 
               "{SERVICE <http://factforge.net/sparql>"+
                 //SERVICE is a feature of SPARQL 1.1 that allows an executing query to to make a SPARQL protocol to another SPARQL endpoint */
               "}"; 
             
             String sparqlQueryThree =
              "PREFIX xmlns:<http://example.org/data/realestate#> \n" +
              "SELECT * \n" +
              "WHERE {\n" + //WHERE indicates the selection pattern -- specifies data to pull out
              "?s ?p ?o. \n" +
              "}";
              
       //Execute the query
       Query query = QueryFactory.create(sparqlQuery);
       
       QueryExecution qe = QueryExecutionFactory.create(query, model);
       ResultSet results = qe.execSelect();
       //Formatting a result set into JSON
       ResultSetFormatter.outputAsJSON(results);
       //ResultSetFormatter.outputAsXML(results);
       //Formatting a result set into standard out
       //ResultSetFormatter.out(System.out, results, query);
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
    

               

 




