package commonmethods

import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Path
import javax.imageio.ImageIO
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider

public class ScreenshotDriverMini {

	@Keyword
	static BufferedImage takeElementImage(WebDriver driver, WebElement webElement){
		Screenshot screenshot = new AShot().
				coordsProvider(new WebDriverCoordsProvider()).
				takeScreenshot(driver, webElement)
		return screenshot.getImage()
	}

	@Keyword
	static void saveElementImage(WebDriver driver, WebElement webElement, Path output) {
		if (!Files.exists(output.getParent())) {
			Files.createDirectories(output.getParent())
		}
		BufferedImage image = takeElementImage(driver, webElement)
		ImageIO.write(image, "PNG", output.toFile())
	}
}
