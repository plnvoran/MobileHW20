package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
})
public interface MobileDriverConfig extends Config {
    @Key("mobile.version")
    String mobileVersion();

    @Key("mobile.deviceName")
    String mobileDevice();

    @Key("mobile.app.path")
    String mobileAppPath();

    @Key("mobile.platformName")
    String mobilePlatformName();

    @Key("browsrrstackPlatformName")
    String browsrrstackPlatformName();

    @Key("mobile.apppackage")
    String mobileAppPackage();

    @Key("mobile.appactivity")
    String mobileAppActivity();

    @Key("mobile.url")
    String mobileUrl();
}