package kz.CitizenApp.services;

import kz.CitizenApp.model.Citizen;
import kz.CitizenApp.searching.SearchDTO;

import java.util.List;

/**
 * Created by ktoloc on 14.06.2016.
 */
public interface CitizenService {

    public Citizen create(Citizen citizen);

    public Citizen get(int id);

    public Citizen update(Citizen citizen);

    public Citizen delete(int id);

    public List<Citizen> getAll();

    public List<Citizen> search(SearchDTO searchCriteria);

}
