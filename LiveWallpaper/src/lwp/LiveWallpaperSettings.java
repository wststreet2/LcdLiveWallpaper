package lwp;


import org.kamehamehaaa.android.livewallpaper.R;

import com.google.ads.*;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class LiveWallpaperSettings extends PreferenceActivity
    implements SharedPreferences.OnSharedPreferenceChangeListener {
	
	AdView adView;

	@Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.settings);
        
        AdRequest ar = new AdRequest();
        ar.addTestDevice(AdRequest.TEST_EMULATOR);
        
        adView = (AdView) findViewById(R.id.adView);

        adView.loadAd(ar);
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