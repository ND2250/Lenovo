import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {


    public static void SelectValueFromDropDown(WebElement element, String Value){
        Select select = new Select(element);
        select.selectByVisibleText(Value);

    }
}
