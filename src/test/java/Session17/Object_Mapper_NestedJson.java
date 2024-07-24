package Session17;

import java.sql.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Object_Mapper_NestedJson {
	
	@Test
	
	void ObjectMapperforNestedJson() throws JsonProcessingException {
		RequestSpecification requestSpecification=RestAssured.given();
		
		requestSpecification.baseUri("https://reqres.in/");
		requestSpecification.basePath("api/users");
		
		ObjectMapper object_mappper= new ObjectMapper();
		
		ObjectNode Payload = object_mappper.createObjectNode();
		
		
		
		Payload.put("name", "Ashish");
		Payload.put("Age", 30);
		Payload.put("salary",1000.5);
		Payload.put("Location", "Faridabad");
		Payload.put("IsMarried", false);
		Payload.set("Hobbies",object_mappper.convertValue(Arrays.asList("Music","Reading"), JsonNode.class));
		
		
		ObjectNode TechSkills = object_mappper.createObjectNode();
		TechSkills.put("Programming Language", "Java");
		TechSkills.put("Department", "Testing");
		TechSkills.put("Automation", "selenium");
		
		Payload.set("TechSkills", TechSkills);
		
		
	/*Response response=requestSpecification.contentType(ContentType.JSON).body(Payload).post();
    response.prettyPrint();*/
    
    
    String objectMapperString=object_mappper.writerWithDefaultPrettyPrinter().writeValueAsString(Payload);
    
    System.out.println("the objectMapper String is : "+objectMapperString);
    
    // fetching the value from the response 
    
    
    System.out.println("----------------Fetching the Key and values using Iterator method ----------");
    String nameString=Payload.get("name").asText();
    System.out.println("the name of the employee :"+nameString);
    
    Boolean IsMarriedStatus=Payload.get("IsMarried").asBoolean();
    System.out.println("the name of the employee :"+IsMarriedStatus);
    
    // to fetch the nested json response
    
    String webAutomationString=Payload.get("TechSkills").get("Automation").asText();
    System.out.println("The Web Automation Skill is :"+webAutomationString);
    
    // to print  the fieldsName
    
    Iterator<String> filedsIterator=Payload.fieldNames();
   while(filedsIterator.hasNext()) {
	   System.out.println(filedsIterator.next());
   }
		
		
   // to print  the Values 
   
   Iterator<JsonNode> valueIterator=Payload.elements();
  while(valueIterator.hasNext()) {
	   System.out.println(valueIterator.next());
	   
	   
	   // to print  the filedsname and value at sametime 
	   
	   Iterator <Entry<String,JsonNode>> KeyValueIterator=Payload.fields();
	  while(KeyValueIterator.hasNext()) {
      Entry<String, JsonNode> node=KeyValueIterator.next();
     System.out.println("The key is :" +node.getKey()+" "+"The value is :"+node.getValue()); 
     //System.out.println(node.getValue());
      
	  }
	  
	  // remove the value 
	  
	 String removedValueString=Payload.remove("name").asText();
	  
	  System.out.println("The removed value of the name :"+removedValueString);
	  
	/* try{
	   String objectMapperString=object_mappper.writerWithDefaultPrettyPrinter().writeValueAsString(Payload);
	    
	    System.out.println("the objectMapper String is : "+objectMapperString);
  }catch (JsonProcessingException e) {
	  e.printStackTrace();
	  
	// TODO: handle exception
}*/
	  
	  //Now send the post request as doing in the prevoius sections
	  
	  
		   
	   
	   
	   
  }
		
	
	}

	

}
