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

    @Key("bs")
    String bs();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

}
