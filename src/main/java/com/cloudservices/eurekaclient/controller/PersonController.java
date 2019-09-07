package com.cloudservices.eurekaclient.controller;
import com.cloudservices.eurekaclient.model.PersonRequest;
import com.cloudservices.eurekaclient.model.PersonResponse;
import com.cloudservices.eurekaclient.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/client")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/person/", method = RequestMethod.GET)
    public List<PersonResponse> getPerson(){
        return personService.retrievePerson();
    }

    @RequestMapping(value = "/person/id", method = RequestMethod.GET)
    public PersonResponse getPerson(@RequestParam int personId){
        return personService.retrievePerson(personId);
    }

    @RequestMapping(value = "/person/", method = RequestMethod.POST)
    public String createPerson(@RequestBody PersonRequest personRequest){
        return personService.createPerson(personRequest);
    }

    @RequestMapping(value = "/person/", method = RequestMethod.PUT)
    public String updatePerson(@RequestBody PersonRequest personRequest, @RequestParam int id){
        return personService.updatePerson(personRequest, id);
    }

    @RequestMapping(value = "/person/", method = RequestMethod.DELETE)
    public String deletePerson(@RequestParam int id){
        return personService.deletePerson(id);
    }

    @RequestMapping(value = "/person/search", method = RequestMethod.GET)
    public List<PersonResponse> searchPerson(@RequestParam Map<String,String> key){
        return personService.searchPerson(key);
    }
}
