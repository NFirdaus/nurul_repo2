/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.deploy.spi.exceptions.ConfigurationException;
import org.apache.jena.graph.GraphUtil;
import org.apache.jena.rdf.model.Statement;
import org.geonames.FeatureClass;
import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.WebService;
import org.omg.CORBA.portable.ValueFactory;

/**
 *
 * @author nurulfirdaus
 */
//public class GeoEnrich {
//    private PlatformConfig config;
//
//	public GeoNamesEnricher(EnricherConfig enricherConfig) throws ConfigurationException {
//		super(enricherConfig);
//		this.config = PlatformConfigHelper.getConfig();
//		WebService.setUserName(config.getString("geonames.api.username"));
//		WebService.setDefaultStyle(Style.FULL);
//	}
//
//	@Override
//	public List<Statement> enrich(EnricherConfig config, NamedGraph graph) {
//		List<Statement> statements = new ArrayList<Statement>();
//		ValueFactory vf = graph.getValueFactory();
//		
//		try {
//			double latitude = GraphUtil.getUniqueObjectLiteral(graph, null, vf.createURI("http://www.w3.org/2003/01/geo/wgs84_pos#lat")).doubleValue();
//			double longitude = GraphUtil.getUniqueObjectLiteral(graph, null, vf.createURI("http://www.w3.org/2003/01/geo/wgs84_pos#long")).doubleValue();
//
//			List<Toponym> searchResult = WebService.findNearby(latitude, longitude, FeatureClass.A, new String[]{"ADM2"});
////			List<Toponym> searchResult = WebService.findNearbyPlaceName(latitude, longitude, 50, 10);
//			
//			for (Toponym toponym : searchResult) {
////				System.out.println(toponym.toString());
//				statements.add(
//						vf.createStatement(graph.getGraphUri(), 
//						vf.createURI("http://www.geonames.org/ontology#Feature"), 
//						vf.createURI("http://sws.geonames.org/"+toponym.getGeoNameId())));
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return statements;
//	}
//    
//}
