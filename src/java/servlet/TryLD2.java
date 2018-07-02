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
//import org.apache.jena.fuseki.*;
/**
 *
 * @author nurulfirdaus
 */
public class TryLD2 {
    public static void main(String[] args) {
    org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
    
    
     String service = "http://localhost:3030/RealEstate/sparql";
     String queryString = "PREFIX re:<http://www.semanticweb.org/nurulfirdaus/ontologies/2017/11/realestate#>\n" +
          "PREFIX owl:<http://www.w3.org/2002/07/owl#>\n" +
          "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
          "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n" +
          "PREFIX gn:<http://www.geonames.org/ontology#>\n" +
          "PREFIX geo:<http://www.w3.org/2003/01/geo/wgs84_pos#>\n" + 
          "PREFIX xmlns:<http://example.org/data/realestate#>\n"+
          "SELECT ?s ?p ?o \n" +
          "WHERE {{GRAPH <http://localhost:3030/RealEstate/data/RealEstateontology>{?s ?p ?o}}}\n" +
          //"WHERE {{GRAPH <http://localhost:3030/RealEstate/data/TransactionPriceData>{?s xmlns:row ?o}}}\n"+
          "LIMIT 10";
     Query query = QueryFactory.create(queryString);
        try (QueryExecution qeRe = QueryExecutionFactory.sparqlService(service, query)) {
            ResultSet results = qeRe.execSelect();//Execute a SELECT query
            ResultSetFormatter.out(System.out, results, query);
        }
}
}
