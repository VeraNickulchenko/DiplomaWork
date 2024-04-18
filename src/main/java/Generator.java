import customizers.LocaleContext;
import customizers.SingletonLocaleContext;
import dataproviders.CredentialsProvider;
import dataproviders.EmailProvider;
import dataproviders.NameProvider;
import services.RandomService;

import java.util.Random;

public class Generator {
    private SingletonLocaleContext locale;
    private RandomService randomService;

    public Generator(LocaleContext localeContext, Random random) {
        this.locale = SingletonLocaleContext.get(localeContext);
        this.randomService = new RandomService(random);
    }

    public Generator(LocaleContext locale){
        this.locale = SingletonLocaleContext.get(locale);
        this.randomService = new RandomService();
    }

    public Generator(Random random){
        this.locale = SingletonLocaleContext.get(new LocaleContext());
        this.randomService = new RandomService(random);
    }

    public NameProvider name(){
        return new NameProvider(locale, randomService);
    }

    public CredentialsProvider credentials(){
        return new CredentialsProvider(locale, randomService);
    }

    public EmailProvider email(){
        return new EmailProvider(locale, randomService);
    }

    public RandomService random(){
        return randomService;
    }


}
