package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class HomePageTest extends BaseTests {

    @Test
    public void shouldSeePopularItemsOnHomePage() {

        List<WebElement> productNames = driver.findElements(By.cssSelector("#homefeatured .product-name"));
        List<WebElement> productsWithEmpyName = productNames.stream()
                .filter(productName -> productName.getText().isEmpty())
                .collect(Collectors.toList());
        assertThat(productsWithEmpyName).isEmpty();
    }


}
