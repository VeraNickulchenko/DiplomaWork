package datagenerator.enums;

/**
 * Enum of languages, supported by the faker.
 * Any of the language, defined in the enum, can be
 * used to initialize the LocaleContext and tell the faker
 * data translated into which language you need it to generate.
 *
 * @author Vira
 */
public enum Languages {
    ENGLISH("en"), UKRAINIAN("ua");

    private String languageCode;

    Languages(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
