package intership.dev.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ScreenSize {

	public static int convertDPToPixels(Context context, int dp) {
		 Resources resources = context.getResources();
		    DisplayMetrics metrics = resources.getDisplayMetrics();
		    float px = dp * (metrics.densityDpi / 160f);
		    return (int) px;
	}

}
