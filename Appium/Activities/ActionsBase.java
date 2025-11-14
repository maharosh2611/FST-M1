package activities;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT; 
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {

	//Set pointer input type
	static PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
	
	//create the sequence of actions
	public static void doSwipe(AppiumDriver driver,Point start,Point end,int duration) {
		Sequence swipe = new Sequence(finger,1). //arguement has what is performing action and number of actions you will perform(minimum value is 1 by default
		addAction(finger.createPointerMove(ofMillis(0), viewport(),start.getX(),start.getY())).
		addAction(finger.createPointerDown(LEFT.asArg())).
		addAction(finger.createPointerMove(ofMillis(duration), viewport(),start.getX(),start.getY())).
		addAction(finger.createPointerDown(LEFT.asArg()));
	//Execute the sequence
		driver.perform(Arrays.asList(swipe));
		
	}
	
}
