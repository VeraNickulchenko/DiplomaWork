package datagenerator.dataproviders;

import datagenerator.customizers.SingletonLocaleContext;
import datagenerator.services.RandomService;

/**
 * Provides methods for generating email addresses, extending the functionality of the BaseProvider class.
 * This class encapsulates the logic for generating email addresses with various parameters such as length,
 * inclusion of upper case letters, numbers, and special characters in the local part, and custom domain names.
 * It also provides methods for generating email addresses with a person's full name as the local part.
 *
 * @author Cas
 */
public class EmailProvider extends BaseProvider{

    public EmailProvider(SingletonLocaleContext locale, RandomService random) {
        super(locale, random);
    }

    /**
     * Creates a new instance of EmailLocalePart, which provides methods for generating email local parts.
     *
     * @return A new EmailLocalePart instance.
     */
    public EmailLocalePart getEmailLocalePart(){
        return new EmailLocalePart();
    }

    /**
     * Generates a random domain name for an email address.
     *
     * @return The generated domain name.
     * This method generates a random domain name with the format "@randomString.com".
     *           The randomString consists of 4 characters and does not include uppercase letters, numbers, or special characters.
     */
    public String getEmailDomainName(){
        return "@" + getRandom()
                .randomString(4, false, false, false) + ".com";
    }

    /**
     * Generates a random email address with the specified parameters for the local part.
     *
     * @param upperLettersInLocalPart If true, include upper case letters in the local part.
     * @param numbersInLocalPart If true, include numbers in the local part.
     * @return The generated email address with a domain name.
     * @see EmailLocalePart#getEmailLocalPart(boolean, boolean) getEmailLocalPart(boolean, boolean)
     * @see #getEmailDomainName() getEmailDomainName()
     */
    public String getEmail(boolean upperLettersInLocalPart, boolean numbersInLocalPart){
        return getEmailLocalePart()
                .getEmailLocalPart(upperLettersInLocalPart, numbersInLocalPart)
                + getEmailDomainName();
    }


    /**
     * Generates a random email address with the specified parameters for the local part and a custom domain.
     *
     * @param upperLettersInLocalPart If true, include upper case letters in the local part.
     * @param numbersInLocalPart If true, include numbers in the local part.
     * @param domain The custom domain name for the email address.
     * @return The generated email address with the specified domain.
     * @see EmailLocalePart#getEmailLocalPart(boolean, boolean) getEmailLocalPart(boolean, boolean)
     */
    public String getEmail(boolean upperLettersInLocalPart, boolean numbersInLocalPart,
                           String domain){
        return getEmailLocalePart()
                .getEmailLocalPart(upperLettersInLocalPart, numbersInLocalPart) + domain;
    }

    /**
     * Generates a random email address with default parameters.
     *
     * @return The generated email address with a domain name.
     * @see EmailLocalePart#getEmailLocalPart() getEmailLocalPart()
     * @see #getEmailDomainName() getEmailDomainName()
     */
    public String getEmail(){
        return getEmailLocalePart().getEmailLocalPart() + getEmailDomainName();
    }

    /**
     * Generates a random email address with a custom domain.
     *
     * @param domain The custom domain name for the email address.
     * @return The generated email address with the specified domain.
     * @see EmailLocalePart#getEmailLocalPart() getEmailLocalPart()
     */
    public String getEmail(String domain){
        return getEmailLocalePart().getEmailLocalPart() + domain;
    }

    /**
     * Generates a random email address with a person's full name in the local part and adds the custom domain name.
     *
     * @param domain The custom domain name for the email address.
     * @return The generated email address with a person's full name and the specified domain name.
     * @see EmailLocalePart#getEmailLocalePartAsFullName() getEmailLocalePartAsFullName()
     */
    public String getEmailWPersonName(String domain){
        return getEmailLocalePart().getEmailLocalePartAsFullName() + domain;
    }

    /**
     * Generates a random email address with a person's full name in the local part, using the specified separator,
     * and adds the custom domain name.
     *
     * @param separator The separator to use between parts of the person's full name.
     * @param domain The custom domain name for the email address.
     * @return The generated email address with a person's full name and the specified domain name.
     * @see EmailLocalePart#getEmailLocalePartAsFullName(String) getEmailLocalePartAsFullName(String)
     */
    public String getEmailWPersonName(String separator, String domain){
        return getEmailLocalePart().getEmailLocalePartAsFullName(separator) + domain;
    }


    /**
     * Generates a random email address with a person's full name in the local part and a default domain name.
     *
     * @return The generated email address with a person's full name and a default domain name.
     * @see EmailLocalePart#getEmailLocalePartAsFullName() getEmailLocalePartAsFullName()
     * @see #getEmailDomainName() getEmailDomainName()
     */
    public String getEmailWPersonName(){
        return getEmailLocalePart().getEmailLocalePartAsFullName() + getEmailDomainName();
    }

    /**
     * Helper class for generating various parts of an email address.
     */
    private class EmailLocalePart{

        /**
         * Generates a random email local part with the specified parameters.
         *
         * @param upperLetters If true, include upper case letters in the generated local part.
         * @param numbers      If true, include numbers in the generated local part.
         * @return The generated email local part.
         * @implNote This method uses a default length of 8 characters for generating the local part.
         */
        public String getEmailLocalPart(boolean upperLetters, boolean numbers){
            return getRandom().randomString(8, upperLetters, numbers, false);
        }


        /**
         * Generates a random email local part with the default length.
         *
         * @return The generated email local part.
         * @implNote This method uses a default length of 8 characters for generating the local part.
         */
        public String getEmailLocalPart(){
            return getEmailLocalPart(false, false);
        }

        /**
         * Generates a local part for an email address using the full name with a specified separator.
         *
         * @param nameSeparator The separator to use between parts of the full name.
         * @return The generated local part based on the full name with the specified separator.
         */
        public String getEmailLocalePartAsFullName(String nameSeparator){
            String fullName = new NameProvider(getLocale(), getRandom()).fullName();
            return fullName.replace(" ", nameSeparator);
        }

        /**
         * Generates a local part for an email address using the full name with an underscore separator.
         *
         * @return The generated local part based on the full name with an underscore separator.
         */
        public String getEmailLocalePartAsFullName(){
            String fullName = new NameProvider(getLocale(), getRandom()).fullName();
            return fullName.replace(" ", "_");
        }

    }




}
