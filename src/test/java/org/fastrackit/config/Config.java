package org.fastrackit.config;

import com.codeborne.selenide.Configuration;

public class Config {
    public Config() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }
}
