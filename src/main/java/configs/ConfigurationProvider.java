package configs;

import org.aeonbits.owner.ConfigFactory;

/** This is a Singleton class, that is used to provide one single object of the Configuration.class,
 * that allows to access values of different keys from the resources/execution_config/test_run.properties
 * and use them inside the project. In order to not create a new Configuration object every time
 * it is required to be accessed, this class has specific method that creates a new object only
 * if it does not exist yet*/
public class ConfigurationProvider {
    private static Configuration config = null;

    private ConfigurationProvider(){

    }

    public static Configuration getConfiguration(){
        if(config == null){
            config = ConfigFactory.create(Configuration.class);
        }

        return config;
    }
}
