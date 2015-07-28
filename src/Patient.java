/**
 * Created by Anar on 7/24/15.
 */
public class Patient {


    public static final String ROOT = "/ClinicalDocument/recordTarget/patientRole";

    public static final String ID = "./id/@root";

    public static final String NAME_PREFIX = "./patient/name/prefix[1]";
    public static final String NAME_PREFIX2 = "./patient/name/prefix[2]";
    public static final String NAME_GIVEN = "./patient/name/given[1]";
    public static final String NAME_GIVEN2 = "./patient/name/given[2]";
    public static final String NAME_FAMILY = "./patient/name/family[1]";
    public static final String NAME_FAMILY2 = "./patient/name/family[2]";
    public static final String NAME_SUFFIX = "./patient/name/suffix[1]";
    public static final String NAME_SUFFIX2 = "./patient/name/suffix[2]";

    public static final String SOCIAL_ID = "./id[2]/@root";
    public static final String TEL = "./telecom[1]/@value";
    public static final String EMAIL = "./telecom[3]/@value";


    public static final String STREET = "./addr/streetAddressLine";
    public static final String POSTAL = "./addr/postalCode";
    public static final String CITY = "./addr/city";
    public static final String STATE = "./addr/state";
    public static final String COUNTRY = "./addr/country";

    public static final String BIRTH_PLACE = "./patient/birthplace/place/addr";
    public static final String GENDER = "./patient/administrativeGenderCode/@displayName";
    public static final String BIRTHTIME = "./patient/birthTime/@value";
    public static final String MARITALSTATUS = "./patient/maritalStatusCode/@displayName";
    public static final String RELIGIOUS = "./patient/religiousAffiliationCode/@displayName";

    public static final String GUARDIAN_STREET = "./patient/guardian/addr/streetAddressLine";
    public static final String GUARDIAN_CITY = "./patient/guardian/addr/city";
    public static final String GUARDIAN_COUNTRY = "./patient/guardian/addr/country";
    public static final String GUARDIAN_STATE = "./patient/guardian/addr/state";


    public static final String GUARDIAN_GIVEN_NAME = "./patient/guardian/guardianPerson/name/given[1]";
    public static final String GUARDIAN_FAMILY_NAME = "./patient/guardian/guardianPerson/name/family[1]";
    public static final String GUARDIAN_TEL = "./patient/guardian/telecom[1]/@value";

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

    public Patient(String id, String socialId, String prefixName, String prefixName2, String givenName, String givenName2, String familyName, String familyName2, String suffixName, String suffixName2, String tel, String email, String street, String postal, String city, String country, String state, String birthPlace, String gender, String birthTime, String maritalStatus, String religion, String guardianStreet, String guardianCity, String guardianState, String guardianCountry, String guardianGivenName, String guardianFamilyName, String guardianTel) {
        this.id = id;
        this.socialId = socialId;
        this.prefixName = prefixName;
        this.prefixName2 = prefixName2;
        this.givenName = givenName;
        this.givenName2 = givenName2;
        this.familyName = familyName;
        this.familyName2 = familyName2;
        this.suffixName = suffixName;
        this.suffixName2 = suffixName2;
        this.tel = tel;
        this.email = email;
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.country = country;
        this.state = state;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.birthTime = birthTime;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.guardianStreet = guardianStreet;
        this.guardianCity = guardianCity;
        this.guardianState = guardianState;
        this.guardianCountry = guardianCountry;
        this.guardianGivenName = guardianGivenName;
        this.guardianFamilyName = guardianFamilyName;
        this.guardianTel = guardianTel;
    }

    public String getId() {
        return id;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public String getPrefixName2() {
        return prefixName2;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getGivenName2() {
        return givenName2;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFamilyName2() {
        return familyName2;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public String getSuffixName2() {
        return suffixName2;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getPostal() {
        return postal;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public String getGuardianStreet() {
        return guardianStreet;
    }

    public String getGuardianCity() {
        return guardianCity;
    }

    public String getGuardianState() {
        return guardianState;
    }

    public String getGuardianCountry() {
        return guardianCountry;
    }

    public String getGuardianGivenName() {
        return guardianGivenName;
    }

    public String getGuardianFamilyName() {
        return guardianFamilyName;
    }

    public String getGuardianTel() {
        return guardianTel;
    }
}

