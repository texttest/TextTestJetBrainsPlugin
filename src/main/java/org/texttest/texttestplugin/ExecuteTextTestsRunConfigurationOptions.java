package org.texttest.texttestplugin;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class ExecuteTextTestsRunConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> texttestHome = string("").provideDelegate(this, "TEXTTEST_HOME");

    private final StoredProperty<Boolean> use_TEXTTEST_HOME_env = property(false).provideDelegate(this, "USE_TEXTTEST_HOME_ENV");


    public String getTextTestHome() {
        return texttestHome.getValue(this);
    }

    public void setTextTestHome(String texttestHome) {
        this.texttestHome.setValue(this, texttestHome);
    }

    public Boolean getUse_TEXTTEST_HOME_env() {
        return use_TEXTTEST_HOME_env.getValue(this);
    }

    public void setUse_TEXTTEST_HOME_env(Boolean value) {
        this.use_TEXTTEST_HOME_env.setValue(this, value);
    }
}
