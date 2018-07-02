/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * @author nurulfirdaus
 */

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

public class TryJena  {
    public static void main (String[]args) throws Exception {
       org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
        //SPARQL Endpoints to throw the queries
        
          String service = "http://linkedgeodata.org/sparql";
          
          //SERVICE operator is to connect with external sparql endpoints
          //String service = "http://linkedgeodata.org/vsnorql/";
          //String service = "https://www.openlinksw.com/sparql";
          //String service = "http://sparql.org/sparql";
          //String service = "http://factforge.net/sparql/";
          //String service = "http://lod.openlinksw.com/sparql";

          
          String queryString = "SELECT distinct ?s ?p ?o \n" +
          "WHERE {?s ?p ?o} \n" +
          "LIMIT 10";
//LIMIT is a solution modifier that limits the number of rows returned from a query.

//        String queryString ="Prefix lgdo: <http://linkedgeodata.org/ontology/>\n" +
//        "Select *\n" +
//        "From <http://linkedgeodata.org> {\n" + //Dataset Definition
//        "?s lgdo:schemaIcon ?o .\n" +
//        "}";
        
//        String queryString="Prefix rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"+
//        "Prefix rdfs:<http://www.w3.org/2000/01/rdf-schema#> \n"+
//        "Prefix lgdo:<http://linkedgeodata.org/ontology/> \n" +
//        "Prefix geom:<http://geovocab.org/geometry#> \n" +
//        "Prefix ogc:<http://www.opengis.net/ont/geosparql#> \n"+
//        "Prefix bif:<http://www.openlinksw.com/schemas/bif#> \n"+
//            "SELECT * \n" +
//            "FROM <http://linkedgeodata.org> {\n" + //dataset name
//            "  ?s \n" +
//            "    rdf:type lgdo:Amenity ;\n" +
//            "    rdfs:label ?l ;    \n" +
//            "    geom:geometry [\n" +
//            "      ogc:asWKT ?g\n" +
//            "    ] .\n" +
//            "FILTER(bif:st_intersects (?g, bif:st_point (137.7041961, 34.7137903), 0.1)) .\n" +
//        //"                                         long, lat                 100m\n" +
//            "}";
        
        
       
          
    Query query = QueryFactory.create(queryString);
        try (QueryExecution qeGeo = QueryExecutionFactory.sparqlService(service, query)) {
            ResultSet results = qeGeo.execSelect();//Execute a SELECT query
            ResultSetFormatter.out(System.out, results, query);
            //ResultSetFormatter.outputAsXML(results);
            
        }
    }
    
}
//curl -X get