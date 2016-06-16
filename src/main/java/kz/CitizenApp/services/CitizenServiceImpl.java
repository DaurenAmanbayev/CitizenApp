package kz.CitizenApp.services;

import kz.CitizenApp.model.Citizen;
import kz.CitizenApp.repository.CitizenRepository;
import kz.CitizenApp.searching.SearchDTO;
import kz.CitizenApp.searching.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ktoloc on 14.06.2016.
 */
@Service
@Transactional
public class CitizenServiceImpl implements CitizenService{
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Citizen create(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public Citizen get(int id) {
        return citizenRepository.findOne(id);
    }

    @Override
    public Citizen update(Citizen citizen) {
        Citizen citizenToUpdate = get(citizen.getId());
        if(citizenToUpdate != null){
            citizenToUpdate.setName(citizen.getName());
            citizenToUpdate.setLastName(citizen.getLastName());
            citizenToUpdate.setBirthDate(citizen.getBirthDate());
            citizenToUpdate.setHomeAddress(citizen.getHomeAddress());
            citizenToUpdate.setDocumentNumber(citizen.getDocumentNumber());
            citizenToUpdate.setDocumentType(citizen.getDocumentType());
            citizenToUpdate.setDocumentCreatedDate(citizen.getDocumentCreatedDate());
            citizenToUpdate.setDocumentExpiredDate(citizen.getDocumentExpiredDate());
            return citizenRepository.save(citizen);
        }
        return null;
    }

    @Override
    public Citizen delete(int id) {
        Citizen citizenToDelete = get(id);
        if(citizenToDelete != null){
            citizenRepository.delete(id);
            return citizenToDelete;
        }
        return null;
    }

    @Override
    public List<Citizen> getAll() {
        return citizenRepository.findAll();
    }

    @Override
    public List<Citizen> search(SearchDTO searchCriteria)
    {
        String searchTerm = searchCriteria.getSearchTerm();
        SearchType searchType = searchCriteria.getSearchType();

        if (searchType == null) {
            throw new IllegalArgumentException();
        }

        return findCitizenBySearchType(searchTerm, searchType);

    }
    //не импользуется!!!
    private List<Citizen> findCitizenBySearchType(String searchTerm, SearchType searchType) {
        List<Citizen> citizens=null;//убрать nullри имплементации
/*
        if (searchType == SearchType.BIRTHDAY_QUERY) {

            citizens = citizenRepository.findByBirthday(searchTerm);
        }
        else if (searchType == SearchType.NAMED_QUERY) {

            citizens = citizenRepository.findByLastName(searchTerm);
        }
        else {

            citizens = citizenRepository.findByDocument(searchTerm);
        }
*/
        return citizens;
    }
}
