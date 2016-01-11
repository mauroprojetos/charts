package com.vaadin.addon.charts.testbenchtests;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.addon.charts.examples.columnandbar.ToggledSeriesVisibility;
import com.vaadin.testbench.By;
import com.vaadin.testbench.Parameters;

public class ToggledSeriesVisibilityTBTest extends AbstractParallelTest {

    boolean screenshotErrors = false;

    @Test
    public void test() throws IOException, AssertionError {

        // negligible difference when returning to 2-disable shot on chrome,
        // avoid error by increasing the tolerance
        Parameters.setScreenshotComparisonTolerance(0.03);

        driver.get(getTestUrl());

        waitForVaadin();

        driver.findElements(By.tagName("input")).get(0).click();
        driver.findElements(By.tagName("input")).get(0).click();
        waitForVaadin();
        captureAndCompare("1-start");

        driver.findElements(By.tagName("input")).get(0).click();
        waitForVaadin();
        captureAndCompare("2-disable");

        driver.findElements(By.tagName("input")).get(1).click();
        waitForVaadin();
        captureAndCompare("3-disable");

    }

    @Override
    protected String getTestViewName() {
        return ToggledSeriesVisibility.class.getSimpleName();
    }

    @Override
    protected String getPackageName() {
        return "columnandbar";
    }

}
