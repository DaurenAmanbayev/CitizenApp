package kz.CitizenApp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ktoloc on 14.06.2016.
 */
@Entity
@Table(name = "citizens")
public class Citizen {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String homeAddress;
    private String documentNumber;
    private String documentType;
    private Date documentCreatedDate;
    private Date documentExpiredDate;

    //region PERSON DATA
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    //endregion

    //region DOCUMENT DATA
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Date getDocumentCreatedDate() {
        return documentCreatedDate;
    }

    public void setDocumentCreatedDate(Date documentCreatedDate) {
        this.documentCreatedDate = documentCreatedDate;
    }

    public Date getDocumentExpiredDate() {
        return documentExpiredDate;
    }

    public void setDocumentExpiredDate(Date documentExpiredDate) {
        this.documentExpiredDate = documentExpiredDate;
    }
    //endregion
}
