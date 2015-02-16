package com.demo;

import com.manager.NotificationManager;
import com.manager.SimpleManager;
import com.notification.NotificationFactory;
import com.notification.NotificationFactory.Location;
import com.notification.types.IconNotification;
import com.notification.types.SimpleTextNotification;
import com.theme.ThemePackagePresets;
import com.utils.IconUtils;
import com.utils.Time;

/**
 * This is a simple demo which uses the SimpleManager to show two different types of Notifications.
 */
public class SimpleManagerDemo {
	public static void main(String[] args) {
		// makes a factory with the built-in clean theme
		NotificationFactory factory = new NotificationFactory(ThemePackagePresets.cleanLight());
		// a normal manager that just pops up the notification
		NotificationManager plain = new SimpleManager(Location.NORTHEAST);
		// a fade manager that will make the window fade in and out over a two second period
		SimpleManager fade = new SimpleManager(Location.NORTHWEST);
		fade.setFadeEnabled(true);
		fade.setFadeTime(Time.seconds(2));

		// adds a text notification to the first manager
		SimpleTextNotification notification = factory.buildTextNotification("This is a title", "This is subtext");
		notification.setCloseOnClick(true);
		// the notification will stay there forever until you click it to exit
		plain.addNotification(notification, Time.infinite());

		// adds an icon notification that should fade in - note that results may vary depending on the platform
		IconNotification icon = factory.buildIconNotification("This is a really really really long title", "This is a subtitle",
				IconUtils.createIcon("/com/demo/exclamation.png", 50, 50));
		// the notification will automatically fade out after five seconds
		fade.addNotification(icon, Time.seconds(5));
	}
}
