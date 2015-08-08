import resource.Patient;

public class PatientBuilder {
    private String id;
    private String socialId;
    private String prefixName;
    private String prefixName2;
    private String givenName;
    private String givenName2;
    private String familyName;
    private String familyName2;
    private String suffixName;
    private String suffixName2;
    private String tel;
    private String email;
    private String street;
    private String postal;
    private String city;
    private String country;
    private String state;
    private String birthPlace;
    private String gender;
    private String birthTime;
    private String maritalStatus;
    private String religion;
    private String guardianStreet;
    private String guardianCity;
    private String guardianState;
    private String guardianCountry;
    private String guardianGivenName;
    private String guardianFamilyName;
    private String guardianTel;

    public PatientBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PatientBuilder socialId(String socialId) {
        this.socialId = socialId;
        return this;
    }

    public PatientBuilder prefixName(String prefixName) {
        this.prefixName = prefixName;
        return this;
    }

    public PatientBuilder prefixName2(String prefixName2) {
        this.prefixName2 = prefixName2;
        return this;
    }

    public PatientBuilder givenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public PatientBuilder givenName2(String givenName2) {
        this.givenName2 = givenName2;
        return this;
    }

    public PatientBuilder familyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public PatientBuilder familyName2(String familyName2) {
        this.familyName2 = familyName2;
        return this;
    }

    public PatientBuilder suffixName(String suffixName) {
        this.suffixName = suffixName;
        return this;
    }

    public PatientBuilder suffixName2(String suffixName2) {
        this.suffixName2 = suffixName2;
        return this;
    }

    public PatientBuilder tel(String tel) {
        this.tel = tel;
        return this;
    }

    public PatientBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PatientBuilder street(String street) {
        this.street = street;
        return this;
    }

    public PatientBuilder postal(String postal) {
        this.postal = postal;
        return this;
    }

    public PatientBuilder city(String city) {
        this.city = city;
        return this;
    }

    public PatientBuilder country(String country) {
        this.country = country;
        return this;
    }

    public PatientBuilder state(String state) {
        this.state = state;
        return this;
    }

    public PatientBuilder birthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
        return this;
    }

    public PatientBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public PatientBuilder birthTime(String birthTime) {
        this.birthTime = birthTime;
        return this;
    }

    public PatientBuilder maritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public PatientBuilder religion(String religion) {
        this.religion = religion;
        return this;
    }

    public PatientBuilder guardianStreet(String guardianStreet) {
        this.guardianStreet = guardianStreet;
        return this;
    }

    public PatientBuilder guardianCity(String guardianCity) {
        this.guardianCity = guardianCity;
        return this;
    }

    public PatientBuilder guardianState(String guardianState) {
        this.guardianState = guardianState;
        return this;
    }

    public PatientBuilder guardianCountry(String guardianCountry) {
        this.guardianCountry = guardianCountry;
        return this;
    }

    public PatientBuilder guardianGivenName(String guardianGivenName) {
        this.guardianGivenName = guardianGivenName;
        return this;
    }

    public PatientBuilder guardianFamilyName(String guardianFamilyName) {
        this.guardianFamilyName = guardianFamilyName;
        return this;
    }

    public PatientBuilder guardianTel(String guardianTel) {
        this.guardianTel = guardianTel;
        return this;
    }

    public Patient createPatient() {
        return new Patient(id, socialId, prefixName, prefixName2, givenName, givenName2, familyName, familyName2, suffixName, suffixName2, tel, email, street, postal, city, country, state, birthPlace, gender, birthTime, maritalStatus, religion, guardianStreet, guardianCity, guardianState, guardianCountry, guardianGivenName, guardianFamilyName, guardianTel);
    }
}