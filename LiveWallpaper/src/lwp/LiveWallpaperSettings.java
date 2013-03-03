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
		setContentView(R.layout.settings);

		spinner = (Spinner) this.findViewById(R.id.spinner1);
		spinner_fr = (Spinner) this.findViewById(R.id.spinner2);
		myList.add("None");
		myList.add("Random");
		myList.add("Gradient");

		myList2.add("Pizza");

		adapter = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, myList);
		adapter2 = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, myList2);
		spinner.setAdapter(adapter);
		spinner_fr.setAdapter(adapter2);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				String eyeCandyName = (String) spinner.getItemAtPosition(arg2);
				SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
				SharedPreferences.Editor editor = settings.edit();

				editor.putString("eyeCandy", eyeCandyName);
				editor.commit();

				MyWallpaper.setEyeCandy(eyeCandyName);
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		spinner.setSelection(0);

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		for (int i = 0; i < spinner.getCount(); i++) {
			if (spinner.getItemAtPosition(i).equals(
					settings.getString("eyeCandy", "None")))
				spinner.setSelection(i);
		}

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