package android.databinding;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
public class DynamicUtil {
    @SuppressWarnings("deprecation")
    public static int getColorFromResource(final android.view.View root, final int resourceId) {
        return root.getResources().getColor(resourceId);
    }
}