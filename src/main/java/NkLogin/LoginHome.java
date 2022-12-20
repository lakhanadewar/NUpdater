package NkLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHome {

	// Author Lakhan Adewar
	// QA Engineer
	
	
	
	@FindBy(xpath = "//div[@class='nI-gNb-header__wrapper']/div/a[@id='login_Layer']")
	private WebElement HeaderLoginBtn;
	@FindBy(xpath = "(//div[@class='drawer-wrapper ']//form/div/input)[1]")
	private WebElement userName;
	@FindBy(xpath = "(//div[@class='drawer-wrapper ']//form/div/input)[2]")
	private WebElement userPass;
	@FindBy(xpath = "(//div[@class='drawer-wrapper ']//form//button)[1]")
	private WebElement LoginBtn;

	public LoginHome(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void clickLoginOnHome() {
		HeaderLoginBtn.click();
	}
	
	
	public void LoginNaukari(String uName,String uPass) {
		
		userName.sendKeys(uName);
		userPass.sendKeys(uPass);
		LoginBtn.click();
		
		
		
	}
	
	
	
	
	
}
