package kz.CitizenApp.repository;

import kz.CitizenApp.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ktoloc on 14.06.2016.
 */
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
/*
    Проблема с обнаружением и валидации запроса
    @Query("SELECT p FROM Citizen p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    public List<Citizen> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM Citizen p WHERE LOWER(p.birthDate) = LOWER(:BirthDate)")
    public List<Citizen> findByBirthday(@Param("birthDate") String BirthDate);

    @Query("SELECT p FROM Citizen p WHERE LOWER(p.documentNumber) = LOWER(:DocumentNumber)")
    public List<Citizen> findByDocument(@Param("documentNumber") String DocumentNumber);
*/
}
