package com.vaadin.addon.charts.testbenchtests;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.addon.charts.examples.columnandbar.ColumnWithNativeLazyDrilldown;
import com.vaadin.testbench.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColumnWithNativeLazyDrilldownTBTest extends AbstractParallelTest {

    @Override
    protected String getTestViewName() {
        return ColumnWithNativeLazyDrilldown.class.getSimpleName();
    }

    @Test
    public void test() throws IOException, AssertionError {
        driver.get(getTestUrl());

        new WebDriverWait(driver, 120).until(ExpectedConditions
                .presenceOfElementLocated(By.id("chart")));
        waitForVaadin();
        captureAndCompare("before");

        WebElement findElement = driver.findElement(By.id("chart"));
        Action moveAndClick = new Actions(driver)
                .moveToElement(findElement, 120, 255).click()
                .moveToElement(findElement, 0, 0).build();
        moveAndClick.perform();

        // move the cursor away from the chart
        new Actions(driver)
                .moveToElement(driver.findElement(By.className("v-ui")), 0, 0)
                .build().perform();

        waitForVaadin();
        captureAndCompare("after");
    }

    @Override
    protected String getPackageName() {
        return "columnandbar";
    }

}
