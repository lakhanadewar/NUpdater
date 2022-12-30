package TestLogin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import NkBase.InvokeBrowser;
import NkLogin.LogHome;
import NkUpdate.UpdateNaukariHome1;
import NkUpdate.UpdateNaukariHome2;
import NkUpdate.UploadResume;
import NkUtility.UtilityData;
import Nklogout.NkLogout;

public class Login2Naukari extends InvokeBrowser {

	LogHome LoginHome;
	UpdateNaukariHome1 UpProfile;
	UpdateNaukariHome2 UpProfile2;
	UploadResume uploadRusm;

	@BeforeClass
	public void Login2App() {

		browserOpen();

		LoginHome = new NkLogin.LogHome(driver);
		UpProfile = new UpdateNaukariHome1(driver);
		UpProfile2 = new UpdateNaukariHome2(driver);
		uploadRusm = new UploadResume(driver);

	}

	@Test
	public void Login2app() throws EncryptedDocumentException, IOException, InterruptedException {

		LoginHome.clickLoginOnHome();
		LoginHome.LoginNaukari(UtilityData.getExceldata(0, 0), UtilityData.getExceldata(0, 1));

		UpProfile.clickOnUpdateProfile();

		String resumepath = "C:\\Users\\lakha\\Documents\\Lakhan Adewar\\00 Desktop Data 2021\\Pictures\\05Friday05\\Fri05\\05FridayBangalore\\Lakhan_Expleo_Resume_new.pdf";

		// this upload resume to profile
		uploadRusm.updateResume(wait, resumepath);

		UpProfile2.ClickUpdateResumeHeadline("Resume Headline");

		UpProfile2.clickonResumeHeadEditButton(wait);

		UpProfile2.EditFinalUpdateResumeheading(wait, UtilityData.getExceldata(0, 2));

	}

	@AfterMethod
	public void logout(ITestResult result) throws InterruptedException, IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			UtilityData.captureScreenShot(driver);
		}

	}

	@AfterClass
	public void ClearAll() {

		LoginHome = null;
		UpProfile = null;
		UpProfile2 = null;

	}

}
