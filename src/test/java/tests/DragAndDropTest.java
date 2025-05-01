package tests;

import base.BaseTest;
import dragAndDrop.DragAndDrop;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    private DragAndDrop dragAndDrop;
    private static final String DROPPABLE_URL = "https://demoqa.com/droppable";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(DROPPABLE_URL);
        dragAndDrop = new DragAndDrop(driver);
    }

    @Test
    public void testDragAndDrop() {
        dragAndDrop.dragAndDrop();
        Assert.assertTrue(dragAndDrop.isDropSuccessful());
    }

    @Test
    public void testDragAndDropByOffset() {
        dragAndDrop.dragAndDropByOffset();
        Assert.assertTrue(dragAndDrop.isDropSuccessful());
    }
}