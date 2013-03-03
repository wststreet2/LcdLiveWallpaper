package lwp;

import java.util.ArrayList;
import java.util.List;

import org.kamehamehaaa.android.livewallpaper.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LiveWallpaperSettings extends PreferenceActivity {
	private List<CharSequence> myList = new ArrayList<CharSequence>();
	private List<CharSequence> myList2 = new ArrayList<CharSequence>();
	private Spinner spinner, spinner_fr;
	private ArrayAdapter<CharSequence> adapter, adapter2;
	private static final String PREFS_NAME = "LcdLiveWallpaperSettings";

	public static String getPrefsName() {
		return PREFS_NAME;
	}

	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}