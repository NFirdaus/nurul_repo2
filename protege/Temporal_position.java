package servlet;

import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Temporal_position <br>
 * @version generated on Thu Jun 21 13:30:55 JST 2018 by nurulfirdaus
 */

public interface Temporal_position extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.w3.org/2006/time#dayOfWeek
     */
     
    /**
     * Gets all property values for the day_of_week property.<p>
     * 
     * @returns a collection of values for the day_of_week property.
     */
    Collection<? extends WrappedIndividual> getDay_of_week();

    /**
     * Checks if the class has a day_of_week property value.<p>
     * 
     * @return true if there is a day_of_week property value.
     */
    boolean hasDay_of_week();

    /**
     * Adds a day_of_week property value.<p>
     * 
     * @param newDay_of_week the day_of_week property value to be added
     */
    void addDay_of_week(WrappedIndividual newDay_of_week);

    /**
     * Removes a day_of_week property value.<p>
     * 
     * @param oldDay_of_week the day_of_week property value to be removed.
     */
    void removeDay_of_week(WrappedIndividual oldDay_of_week);


    /* ***************************************************
     * Property http://www.w3.org/2006/time#timeZone
     */
     
    /**
     * Gets all property values for the in_time_zone property.<p>
     * 
     * @returns a collection of values for the in_time_zone property.
     */
    Collection<? extends WrappedIndividual> getIn_time_zone();

    /**
     * Checks if the class has a in_time_zone property value.<p>
     * 
     * @return true if there is a in_time_zone property value.
     */
    boolean hasIn_time_zone();

    /**
     * Adds a in_time_zone property value.<p>
     * 
     * @param newIn_time_zone the in_time_zone property value to be added
     */
    void addIn_time_zone(WrappedIndividual newIn_time_zone);

    /**
     * Removes a in_time_zone property value.<p>
     * 
     * @param oldIn_time_zone the in_time_zone property value to be removed.
     */
    void removeIn_time_zone(WrappedIndividual oldIn_time_zone);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}