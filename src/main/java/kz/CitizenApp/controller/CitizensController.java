package kz.CitizenApp.controller;

import kz.CitizenApp.model.Citizen;
import kz.CitizenApp.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ktoloc on 14.06.2016.
 */
@Controller
@RequestMapping(value = "/citizens")
public class CitizensController {

    @Autowired
    private CitizenService citizenService;

    @RequestMapping(value = "create/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Citizen createCitizen(@RequestBody Citizen citizen) {
        return citizenService.create(citizen);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Citizen editCitizen(@PathVariable int id,
                               @RequestBody Citizen citizen) {
        citizen.setId(id);
        return citizenService.update(citizen);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Citizen deleteCitizen(@PathVariable int id) {
        return citizenService.delete(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Citizen> allCitizens() {
        return citizenService.getAll();
    }
}