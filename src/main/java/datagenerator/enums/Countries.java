package datagenerator.enums;

/**
 * Enum of countries, supported by the faker.
 * Any of the country, defined in the enum, can be
 * used to initialize the LocaleContext and tell the faker
 * data specific to which country you need it to generate.
 *
 * @author Vira
 */
public enum Countries {
    USA("us"), UKRAINE("ua");

    private String countryCode;

    Countries(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode(){
        return this.countryCode;
    }
}
