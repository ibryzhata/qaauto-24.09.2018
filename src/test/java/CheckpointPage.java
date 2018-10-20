import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckpointPage {
    private WebDriver webDriver;
    private WebElement errorEmail;

    public CheckpointPage (WebDriver webDriver){
        this.webDriver = webDriver;
        initElements();
    }
    public boolean isCheckpointPageLoad (){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/checkpoint/lg/login-challenge-submit?lastCv=AgFF2MyDf4vvCwAAAWaSuBPPrFocamQcQP3unaCRvwLV_Gamyfcg-f4K2-M&%2F_d=d&vcd=AgHS9zWX4eJkNwAAAWaSuDktqIZ-RecNXf3tpW8metkiB2-RsvYjuiv4YWLFEd0xYKWwfT9PvnWBpnT7WPCUnLJt9-7iVQ&pageInstance=urn%3Ali%3Apage%3Ad_checkpoint_ch_captchaV2Challenge%3BNeXZCQ5KT1m5Gy52g3GGAQ%3D%3D&controlId=d_checkpoint_ch_captchaV2Challenge-Submit&ut=2uVNmkPnRfG8s1")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isErrorEmailDisplayed();

    }

    public boolean isErrorEmailDisplayed(){
        return errorEmail.isDisplayed();
    }

    public void initElements(){
        errorEmail = webDriver.findElement(By.xpath("//div[@error-for='username']"));
    }


}
