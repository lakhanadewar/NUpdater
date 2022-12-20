package TestLogin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import NkBase.InvokeBrowser;
import NkLogin.LoginHome;
import NkUpdate.UpdateNaukariHome1;
import NkUpdate.UpdateNaukariHome2;
import NkUtility.UtilityData;

public class Login2Naukari extends InvokeBrowser {

	LoginHome LogHome;
	UpdateNaukariHome1 UpProfile;
	UpdateNaukariHome2 UpProfile2;

	@BeforeClass
	public void Login2App() {

		browserOpen();

		LogHome = new LoginHome(driver);
		UpProfile = new UpdateNaukariHome1(driver);
		UpProfile2 = new UpdateNaukariHome2(driver);
	}

	@Test
	public void Login2app() throws EncryptedDocumentException, IOException, InterruptedException {

		LogHome.clickLoginOnHome();
		LogHome.LoginNaukari(UtilityData.getExceldata(0, 0), UtilityData.getExceldata(0, 1));

		UpProfile.clickOnUpdateProfile();
		UpProfile2.ClickUpdateResumeHeadline("Resume Headline");
		UpProfile2.clickonResumeHeadEditButton(wait);

		UpProfile2.EditFinalUpdateResumeheading(wait);

	}

	@AfterMethod
	public void logout(ITestResult result) throws InterruptedException, IOException {
		if (result.getStatus() == result.FAILURE) {

			UtilityData.captureScreenShot(driver);
		}

	}

}
