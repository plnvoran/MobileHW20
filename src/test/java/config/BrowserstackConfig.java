package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties",
        "classpath:${env}.properties"
})

public interface BrowserstackConfig extends Config {
    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

}
