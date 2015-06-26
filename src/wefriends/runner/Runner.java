package wefriends.runner;

import android.os.RemoteException;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
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
		System.out.println("Start WeChat ... ");
		WeChat.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		UiObject Discover = new UiObject(new UiSelector().text("Discover"));
		System.out.println("click Discover");
		Discover.click();

		UiObject PeopleNearby = new UiObject(
				new UiSelector().text("People Nearby"));
		System.out.println("People Nearby");
		PeopleNearby.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 20; i++) {
			swipeOneScreen(device);
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

			clickOneItem(device);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			UiSelector ui = new UiSelector();
			if (ui.textContains("Send Greeting") != null) {

				sendGreeting(device);

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				back(device);

				swipeOneItem(device);

			} else {
				back(device);
				swipeOneItem(device);
			}

		}

	}

	/**
	 * @param device
	 */
	public void back(UiDevice device) {
		System.out.println("device.pressBack()");
		device.pressBack();
	}

	/**
	 * @param device
	 * @throws UiObjectNotFoundException
	 */
	public void sendGreeting(UiDevice device) throws UiObjectNotFoundException {
		UiObject SendGreeting = new UiObject(
				new UiSelector().text("Send Greeting"));
		System.out.println("Send Greeting");
		SendGreeting.click();
		// shift metastate=1 public boolean pressKeyCode(int keyCode,
		// int metaState) ShuangPin Mode
		device.pressKeyCode(KeyEvent.KEYCODE_H);
		device.pressKeyCode(KeyEvent.KEYCODE_A);
		device.pressKeyCode(KeyEvent.KEYCODE_L);
		device.pressKeyCode(KeyEvent.KEYCODE_B);
		device.pressKeyCode(KeyEvent.KEYCODE_COMMA);
		device.pressKeyCode(KeyEvent.KEYCODE_N);
		device.pressKeyCode(KeyEvent.KEYCODE_I);
		device.pressKeyCode(KeyEvent.KEYCODE_H);
		device.pressKeyCode(KeyEvent.KEYCODE_K);

		device.pressKeyCode(KeyEvent.KEYCODE_AT);
		device.pressKeyCode(KeyEvent.KEYCODE_AT);

		UiObject Send = new UiObject(new UiSelector().text("Send"));
		System.out.println("Send");
		Send.click();
	}

	/**
	 * @param device
	 */
	public void clickOneItem(UiDevice device) {
		// click 1 item and add friend
		System.out.println("click 1 item and add friend");
		device.click(360, 820);
	}

	/**
	 * @param device
	 */
	public void swipeOneItem(UiDevice device) {
		int startX = 360;
		int startY = 1216;
		int endX = 360;
		int endY = 146;
		int steps = 10;
		System.out.println("device.swipe(startX, 800, endX, 800 + 119, 10)");
		device.swipe(startX, 800, endX, 800 + 119, steps);
	}

	/**
	 * @param device
	 */
	public void swipeOneScreen(UiDevice device) {
		// swipe the list to the bottom
		int startX = 360;
		int startY = 1216;
		int endX = 360;
		int endY = 146;
		int steps = 10;
		System.out.println("swipe the list to the bottom");
		device.swipe(startX, startY, endX, endY, steps);
	}
}
