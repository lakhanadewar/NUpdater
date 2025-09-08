package NkUpdate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateNaukariHome1 {

	
	
	@FindBy(xpath = "//div[contains(@class,'user-details')]//div[@class=\"other-info-wrapper\"]//a")
	private WebElement updateBtn;

	public UpdateNaukariHome1(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickOnUpdateProfile() throws InterruptedException {

		Thread.sleep(2000);
		updateBtn.click();
		

	}

}
