package com.youtility.energyswitchcui;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

import com.facebook.litho.config.ComponentsConfiguration;
import com.facebook.testing.screenshot.ScreenshotRunner;
import com.facebook.testing.screenshot.layouthierarchy.LayoutHierarchyDumper;
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoAttributePlugin;
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoHierarchyPlugin;

public class SnapshotTestRunner extends AndroidJUnitRunner {

    static {
        ComponentsConfiguration.isDebugModeEnabled = true;
        LayoutHierarchyDumper.addGlobalHierarchyPlugin(LithoHierarchyPlugin.getInstance());
        LayoutHierarchyDumper.addGlobalAttributePlugin(LithoAttributePlugin.getInstance());
    }


    @Override
    public void onCreate(Bundle args) {
        ScreenshotRunner.onCreate(this, args);
        super.onCreate(args);
    }

    @Override
    public void finish(int resultCode, Bundle results) {
        ScreenshotRunner.onDestroy();
        super.finish(resultCode, results);
    }
}
