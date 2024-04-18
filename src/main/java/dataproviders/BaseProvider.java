package dataproviders;

import customizers.SingletonLocaleContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.RandomService;


/**
 * Provides a base class for other faker data providers with common functionality.
 *
 * @author Cas
 */
public class BaseProvider {
    private SingletonLocaleContext locale;
    private RandomService random;

    private final Logger ISSUE_LOG = LogManager.getLogger(this);

    public BaseProvider(SingletonLocaleContext locale, RandomService random) {
        this.locale = locale;
        this.random = random;
    }

    public SingletonLocaleContext getLocale() {
        return locale;
    }

    public RandomService getRandom() {
        return random;
    }

    public Logger getISSUE_LOG() {
        return ISSUE_LOG;
    }
}
