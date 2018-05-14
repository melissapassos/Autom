package testecase;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTesteCase {
	private WebDriver driver;
	
	
	@Before
	
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		this.driver.get("http://demo.virtuemart.net/");
	}
	
	@Test
	public void testMain() {		
		WebElement usernameTextField = this.driver.findElement(By.id("#modlgn-username.inputbox"));
		WebElement passwordTextField = this.driver.findElement(By.id("#modlgn-passwd.inputbox"));
		WebElement loginButton = this.driver.findElement(By.id("#input.button"));
		
		usernameTextField.sendKeys ("demo");
		passwordTextField.sendKeys ("demo");
		loginButton.click();
		
		LoginVerifPoint();
	}

	private void LoginVerifPoint() {
		if((this.driver.getPageSource().contains("Sua Mensagem"))) {
			System.out.println("Entrou !");
		} else {
			System.out.println("Não encontrou! ");
		}
		assertTrue(this.driver.getPageSource().contains("Hi Demo!"));
	}
	
	@After
	public void tearDown() {
		
		this.driver.quit();	
	}
}
// <input id="modlgn-username" name="username" class="inputbox" size="18" type="text">
