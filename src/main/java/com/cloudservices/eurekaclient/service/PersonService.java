package com.cloudservices.eurekaclient.service;

import com.cloudservices.eurekaclient.model.PersonRequest;
import com.cloudservices.eurekaclient.model.PersonResponse;
import com.cloudservices.eurekaclient.personclient.PersonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PersonService {

    @Autowired
    PersonClient personClient;

    public PersonResponse retrievePerson(int id){
        return personClient.getPersonDetails(id);
    }

    public List<PersonResponse> retrievePerson(){
        return personClient.getPersons();
    }

    public String createPerson(PersonRequest personRequest) {
        return personClient.createPerson(personRequest);
    }

    public String updatePerson(PersonRequest personRequest, int id) {
       return personClient.updatePerson(personRequest, id);
    }

    public String deletePerson(int id) {
        return personClient.deletePersonById(id);
    }

    public List<PersonResponse> searchPerson(Map<String,String> key) {
        return personClient.filterPersonsByKey(key);
    }
}
