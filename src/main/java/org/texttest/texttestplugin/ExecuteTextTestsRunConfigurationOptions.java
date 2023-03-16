package org.texttest.texttestplugin;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class ExecuteTextTestsRunConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> texttestHome = string(null).provideDelegate(this, "TEXTTEST_HOME");

    public String getTextTestHome() {
        return texttestHome.getValue(this);
    }

    public void setTextTestHome(String texttestHome) {
        this.texttestHome.setValue(this, texttestHome);
    }
}
