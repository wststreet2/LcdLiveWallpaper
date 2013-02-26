package lwp;


import org.kamehamehaaa.android.livewallpaper.R;

import com.google.ads.*;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.LinearLayout;

public class LiveWallpaperSettings extends PreferenceActivity
    implements SharedPreferences.OnSharedPreferenceChangeListener {
	
	AdView adView;

	@Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.settings);

        adView = new AdView(this, AdSize.BANNER, "");

        LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);

        layout.addView(adView);

        adView.loadAd(new AdRequest());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
            String key) {
    }
}