package NkUpdate;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateNaukariHome2 {

	@FindBy(css = "div[class*='quickLink '] ul li[class='collection-item']")
	private List<WebElement> quickLink4Update;
	@FindBy(xpath = "//div[@id='lazyResumeHead']//span[@class='edit icon']")
	private WebElement ResumeHeadEditBtn;
	@FindBy(xpath = "//div[@class='ltLayer open']")
	private WebElement layerofPopUp;
	@FindBy(xpath = "//form[@name='resumeHeadlineForm']//textarea")
	private WebElement ResumeHeadLineText;
	@FindBy(xpath = "//form[@name='resumeHeadlineForm']//button")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@id='lazyResumeHead']//div[@class='msgBox success']")
	private WebElement successMsgBox;
	Actions act;
	JavascriptExecutor js;
	String ResumeHeadLine;

	public UpdateNaukariHome2(WebDriver driver) {

		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js = ((JavascriptExecutor) driver);
	}

	public void ClickUpdateResumeHeadline(String UpdateWhat) {

		List<WebElement> ss = quickLink4Update.stream().filter(s -> s.getText().equals(UpdateWhat))
				.collect(Collectors.toList());

		for (WebElement x : ss) {

			x.click();
			break;
		}
	}

	public void clickonResumeHeadEditButton(WebDriverWait wait) throws InterruptedException {

		// this will click on edit button of resume headline
		ResumeHeadEditBtn.click();
		// wait.until(ExpectedConditions.visibilityOf(layerofPopUp));
		// this extract the test from the text box
		ResumeHeadLine = ResumeHeadLineText.getText();
		// System.out.println(ResumeHeadLine);

		act.moveToElement(ResumeHeadLineText).click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE)
				.keyUp(Keys.CONTROL).sendKeys("hello hi update this resume heading").build().perform();

		// act.moveToElement(ResumeHeadLineText).click().sendKeys(Keys.DELETE,
		// Keys.DELETE, Keys.DELETE).build().perform();

		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();

	}

	public void EditFinalUpdateResumeheading(WebDriverWait wait) throws InterruptedException {

		// this will click on edit button again of resume headline
		wait.until(ExpectedConditions.invisibilityOf(successMsgBox));

		ResumeHeadEditBtn.click();

		act.moveToElement(ResumeHeadLineText).click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE)
				.keyUp(Keys.CONTROL).sendKeys(ResumeHeadLine).build().perform();

		// act.moveToElement(ResumeHeadLineText).click().sendKeys(Keys.DELETE,
		// Keys.DELETE, Keys.DELETE).build().perform();

		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();

	}

}
