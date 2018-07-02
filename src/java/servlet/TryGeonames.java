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
import java.util.List;
import org.geonames.*;
import org.geonames.WebService;
import org.jdom.*;//jdom used to parse the xml web service result

public class TryGeonames  {
   public static void main (String[]args) throws Exception{
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF); 
   WebService.setUserName("nurul_firdaus"); 
   
    //WebService.findNearbyPlaceName(34.7137903, 137.7041961);
   
    //http://www.geonames.org/source-code/javadoc/
    ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
    searchCriteria.setQ("japan");
   
    ToponymSearchResult searchResult = WebService.search(searchCriteria);
    for (Toponym toponym : searchResult.getToponyms()) {
    System.out.println(toponym.getName()+" "+ toponym.getCountryName());
     
    PostalCodeSearchCriteria postalCodeSearchCriteria = new PostalCodeSearchCriteria();
    postalCodeSearchCriteria.setLatitude(34.7137903);
    postalCodeSearchCriteria.setLongitude(137.7041961);
    List<PostalCode> postalCodes = WebService.findNearbyPostalCodes(postalCodeSearchCriteria);
    System.out.println(postalCodes);
     
   }
  }

}
