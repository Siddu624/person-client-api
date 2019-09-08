package com.cloudservices.eurekaclient.personclient;

import com.cloudservices.eurekaclient.model.PersonRequest;
import com.cloudservices.eurekaclient.model.PersonResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonClient {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPerson")
    public PersonResponse getPersonDetails(int id) {
        return restTemplate.getForObject("https://person-profile-api.herokuapp.com/api/person/id?personId="+id, PersonResponse.class);
    }

    @HystrixCommand(fallbackMethod = "getPersonList")
    public List<PersonResponse> getPersons() {
        ResponseEntity<List<PersonResponse>> response = restTemplate.exchange("https://person-profile-api.herokuapp.com/api/person/", HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResponse>>(){});
        List<PersonResponse> personResponseList = response.getBody();
        return personResponseList;
    }

    @HystrixCommand(fallbackMethod = "createPersonfallback")
    public String createPerson(PersonRequest personRequest) {
   //  return restTemplate.exchange("http://PERSON-USER-PROFILE-API/api/person/", HttpMethod.POST, null, String.class).getBody();
        String response = restTemplate.postForObject(
                "https://person-profile-api.herokuapp.com/api/person/",personRequest,
                String.class);
        return response;
    }
    @HystrixCommand(fallbackMethod = "updatePersonfallback")
    public String updatePerson(PersonRequest personUpdateRequest, int id) {
            return restTemplate.exchange("http://PERSON-USER-PROFILE-API/api/person/?personId="+id, HttpMethod.PUT,
                    new HttpEntity<>(personUpdateRequest),String.class).getBody().toString();

    }

    @HystrixCommand(fallbackMethod = "deletePersonByIdfallback")
    public String deletePersonById(int id) {
        restTemplate.exchange("https://person-profile-api.herokuapp.com/api/person/?personId="+id,HttpMethod.DELETE,null,String.class).getBody().toString();
        return "Deleted succesfully";

    }
    @HystrixCommand(fallbackMethod = "filterPersonBykeyfallback")
    public List<PersonResponse> filterPersonsByKey(Map<String,String> allParams) {
        ResponseEntity<List<PersonResponse>> response = null;
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            response = restTemplate.exchange("https://person-profile-api.herokuapp.com/api/person/search?"+entry.getKey()+"="+entry.getValue(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResponse>>(){});
        }
        List<PersonResponse> personResponseList = response.getBody();
        return personResponseList;
    }

    private List<PersonResponse> filterPersonBykeyfallback(Map<String,String> key) {
         List<PersonResponse> personResponseList = new ArrayList<>();
         return personResponseList;
    }

    private PersonResponse getPerson(int id) {
        return new PersonResponse();
    }

    private  List<PersonResponse> getPersonList() {
        List<PersonResponse> personResponseList = new ArrayList<>();
       return personResponseList;
    }

    private  String createPersonfallback(PersonRequest personRequest) {
        return new String();
    }

    private  String updatePersonfallback(PersonRequest personRequest, int id) {
        return new String();
    }

    private  String deletePersonByIdfallback(int id) {
        return new String();
    }
}
