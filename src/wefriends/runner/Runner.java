package wefriends.runner;

import android.os.RemoteException;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * @author chenguangjian
 */
public class Runner extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException, RemoteException {
		UiDevice device = getUiDevice();

		if (!device.isScreenOn()) {
			// wake up the screen
			System.out.println("wake up the screen");
			try {
				device.wakeUp();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			// swipe to unlock the screen
			System.out.println("swipe to unlock the screen");
			device.swipe(360, 1000, 700, 1000, 1);
		}

		device.pressHome();
		UiObject WeChat = new UiObject(new UiSelector().text("WeChat"));
		System.out.println("click WeChat");
		WeChat.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		UiObject Discover = new UiObject(new UiSelector().text("Discover"));
		System.out.println("click Discover");
		Discover.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UiObject PeopleNearby = new UiObject(
				new UiSelector().text("People Nearby"));
		System.out.println("People Nearby");
		PeopleNearby.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// swipe the list to the bottom
		int startX = 360;
		int startY = 1216;
		int endX = 360;
		int endY = 146;
		int steps = 10;

		for (int i = 0; i < 20; i++) {
			System.out.println("swipe the list to the bottom");
			device.swipe(startX, startY, endX, endY, steps);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (true) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// click 1 item and add friend
			System.out.println("click 1 item and add friend");
			device.click(360, 820);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			UiSelector ui = new UiSelector();
			if (ui.textContains("Send Greeting") != null) {
				UiObject SendGreeting = new UiObject(
						new UiSelector().text("Send Greeting"));
				System.out.println("");
				SendGreeting.click();
				// shift metastate=1 public boolean pressKeyCode(int keyCode,
				// int metaState)
				device.pressKeyCode(KeyEvent.KEYCODE_H, 1);
				device.pressKeyCode(KeyEvent.KEYCODE_I);
				device.pressKeyCode(KeyEvent.KEYCODE_COMMA);
				device.pressKeyCode(KeyEvent.KEYCODE_AT);
				device.pressKeyCode(KeyEvent.KEYCODE_AT);

				UiObject Send = new UiObject(new UiSelector().text("Send"));
				System.out.println("Send");
				Send.click();

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("device.pressBack()");
				device.pressBack();
				System.out
						.println("device.swipe(startX, 800, endX, 800 + 119, 10)");
				device.swipe(startX, 800, endX, 800 + 119, 10);
			
				
			} else {
				System.out.println("device.pressBack();");
				device.pressBack();
				System.out
						.println("device.swipe(startX, 800, endX, 800 + 119, 10);");
				device.swipe(startX, 800, endX, 800 + 119, 10);
			}

		}

	}
}
