package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties",
        "system:properties"
})

public interface BrowserstackConfig extends Config {
    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

    @Key("bs")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String bs();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("osVersion")
    @DefaultValue("9.0")
    String osVersion();

    @Key("project")
    @DefaultValue("First Java Project")
    String projectName();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String buildName();

    @Key("name")
    @DefaultValue("first_test")
    String testName();

}
