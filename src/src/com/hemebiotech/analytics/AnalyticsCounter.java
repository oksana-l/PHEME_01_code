package src.com.hemebiotech.analytics;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author oleroy
 *
 */
public class AnalyticsCounter {

	public static void main(String[] args) {
		
		ReadSymptomDataFromFile symptom = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = symptom.GetSymptoms();
		Set<String> symptomsSet = new HashSet<String>(symptoms);

		symptoms.stream()
        	.map(getFunction(symptoms, symptoms.size() != symptomsSet.size()))
        	.collect(Collectors.toSet())
        	.forEach(System.out::println);
	}

	static Function<String, String> getFunction(List<String> symptoms, boolean hasDuplicates){
	      
	    return hasDuplicates ?  
	    		symptom -> symptom + " (" + Collections.frequency(symptoms, symptom) + ")"
	          : Function.identity();
	}

}