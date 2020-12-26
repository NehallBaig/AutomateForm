import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Assignment {

    // Form Screen
    static WebElement txt_firstName, txt_lastname, txt_jobTitle, rb_education, cb_gender, dd_experienceYear, dp_Date, btn_submit, x_Path_Experience;

    // Thanks Page Element
    static WebElement lb_thanks;
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        String _firstName, _lastname, _jobTitle, _gradSchool;
        char _education, _gender, _experienceYear;
        Scanner input = new Scanner(System.in);

        System.out.println("***************************************Complete Web Form PAGE***************************************");

        // Taking Name from the user
        System.out.println("Enter your first Name");
        _firstName = input.nextLine();

        // Taking LastName from the user
        System.out.println("Enter your last Name");
        _lastname = input.nextLine();

        // Taking Job Title from the user
        System.out.println("Enter your Job Title");
        _jobTitle = input.nextLine();

        // Taking Education from the user
        System.out.println("\nSelect your Highest level of education \n");
        System.out.println("press h for High School");
        System.out.println("press c for College");
        System.out.println("press g for Grad School");
        System.out.println();

        _education = input.next().charAt(0);

        // Taking Gender from the user
        System.out.println("\nSelect your Gender \n");
        System.out.println("press m for Male");
        System.out.println("press f for Female");
        System.out.println("press n for Prefer not to say");
        System.out.println();

        _gender = input.next().charAt(0);

        // Taking Year of Experience from the user
        System.out.println("\nSelect your Years of experience: \n");
        System.out.println("press a for '0-1'");
        System.out.println("press b for '2-4'");
        System.out.println("press c for '5-9'");
        System.out.println("press d for '10+'");
        System.out.println();

        _experienceYear = input.next().charAt(0);

        //Setting Path and Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nbaig\\IdeaProjects\\TASK_Selenium_WebDriver_1\\src\\webDrivers\\chromedriver.exe");

        // Initiate Chrome Driver Object
        driver = new ChromeDriver();

        // Navigate to Assignment Form
        driver.get("http://formy-project.herokuapp.com/form");

        // Sending keys to firstname field
        txt_firstName = driver.findElement(By.id("first-name"));
        txt_firstName.sendKeys(_firstName);

        // Sending keys to lastname field
        txt_lastname = driver.findElement(By.id("last-name"));
        txt_lastname.sendKeys(_lastname);

        // Sending keys to Job Title field
        txt_jobTitle = driver.findElement(By.id("job-title"));
        txt_jobTitle.sendKeys(_jobTitle);

        // Selecting education radio button
        setEducation(_education);

        // Checked gender checkbox
        setGender(_gender);

        // Clicking on Drop Down to select Years of Experience
        dd_experienceYear = driver.findElement(By.id("select-menu"));
        dd_experienceYear.click();

        // Delay for 1 seconds
        Thread.sleep(1000);

        // Selecting Years of Experience from the DropDown
        setExperienceYear(_experienceYear);

        // Selecting Present Date
        dp_Date = driver.findElement(By.cssSelector("input#datepicker"));
        dp_Date.sendKeys(LocalDate.now().toString());

        //submitting form by clicking button
        btn_submit = driver.findElement(By.cssSelector("a.btn"));
        btn_submit.click();

        //******************************************THANKS PAGE******************************************//

        //Navigate to Thanks Page
        driver.get("http://formy-project.herokuapp.com/thanks");

        //Getting label Text by getText Method
        lb_thanks = driver.findElement(By.xpath("//div[@role='alert']"));
        System.out.println("LABEL TEXT :  " + lb_thanks.getText());

        //Quit driver and the window
        driver.quit();

    }

    static void setExperienceYear(char yearExperience) {
        System.out.println(yearExperience);
        switch (yearExperience) {
            case 'a':
                x_Path_Experience = driver.findElement(By.xpath("//option[@value='1']"));
                break;

            case 'b':
                x_Path_Experience = driver.findElement(By.xpath("//option[@value='2']"));
                break;

            case 'c':
                x_Path_Experience = driver.findElement(By.xpath("//option[@value='3']"));
                break;

            case 'd':
                x_Path_Experience = driver.findElement(By.xpath("//option[@value='4']"));
                break;

            default:
                System.out.println("Invalid");
                break;

        }
        x_Path_Experience.click();
    }

    static void setEducation(char _education) {
        switch (_education) {
            case 'h':
                rb_education = driver.findElement(By.id("radio-button-1"));
                rb_education.click();
                break;

            case 'c':
                rb_education = driver.findElement(By.id("radio-button-2"));
                rb_education.click();
                break;

            case 'g':
                rb_education = driver.findElement(By.id("radio-button-3"));
                rb_education.click();
                break;

            default:
                System.out.println("Invalid");
                break;
        }
    }

    static void setGender(char _gender) {
        switch (_gender) {
            case 'm':
                cb_gender = driver.findElement(By.cssSelector("input#checkbox-1"));
                cb_gender.click();
                break;

            case 'f':
                cb_gender = driver.findElement(By.cssSelector("input#checkbox-2"));
                cb_gender.click();
                break;

            case 'n':
                cb_gender = driver.findElement(By.cssSelector("input#checkbox-3"));
                cb_gender.click();
                break;

            default:
                System.out.println("Invalid");
                break;
        }

    }

}
