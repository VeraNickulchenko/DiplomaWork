package datagenerator;

import datagenerator.customizers.LocaleContext;
import datagenerator.customizers.SingletonLocaleContext;
import datagenerator.dataproviders.CredentialsProvider;
import datagenerator.dataproviders.EmailProvider;
import datagenerator.dataproviders.NameProvider;
import datagenerator.services.RandomService;

import java.util.Random;

public class DataFaker {
    private SingletonLocaleContext locale;
    private RandomService randomService;

    public DataFaker(LocaleContext localeContext, Random random) {
        this.locale = SingletonLocaleContext.get(localeContext);
        this.randomService = new RandomService(random);
    }

    public DataFaker(LocaleContext locale){
        this.locale = SingletonLocaleContext.get(locale);
        this.randomService = new RandomService();
    }

    public DataFaker(Random random){
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
