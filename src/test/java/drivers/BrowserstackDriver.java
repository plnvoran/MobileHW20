package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    static  BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {


        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        
        // Set your access credentials
        System.out.println("************************************************************BrowserstackDriver");
        mutableCapabilities.setCapability("browserstack.user", config.username());
        System.out.println(config.username());
        mutableCapabilities.setCapability("browserstack.key", config.password());

        System.out.println(config.password());
        // Set URL of the application under test
        mutableCapabilities.setCapability("app", mobileConfig.bs());

        System.out.println(mobileConfig.bs());
        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", mobileConfig.device());

        System.out.println( mobileConfig.osVersion());
        mutableCapabilities.setCapability("os_version", mobileConfig.osVersion());

        // Set other BrowserStack capabilities
        System.out.println(mobileConfig.projectName());
        mutableCapabilities.setCapability("project", mobileConfig.projectName());
        System.out.println(mobileConfig.buildName());
        mutableCapabilities.setCapability("build", mobileConfig.buildName());
        System.out.println(mobileConfig.testName());
        mutableCapabilities.setCapability("name", mobileConfig.testName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        System.out.println(config.baseUrl());
        try {
            return new RemoteWebDriver(
                    new URL(config.baseUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
