package lwp;

import java.util.ArrayList;
import java.util.List;

import org.kamehamehaaa.android.livewallpaper.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LiveWallpaperSettings extends PreferenceActivity implements
		SharedPreferences.OnSharedPreferenceChangeListener {
	private List<CharSequence> myList = new ArrayList<CharSequence>();
	private List<CharSequence> myList2 = new ArrayList<CharSequence>();
	private Spinner spinner, spinner_fr;
	private ArrayAdapter<CharSequence> adapter, adapter2;
	private static final String PREFS_NAME = "LcdLiveWallpaperSettings";
	

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
		
		spinner.setOnItemSelectedListener(new EyeCandyListener());
		spinner.setSelection(0);
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		for(int i = 0; i< spinner.getCount(); i++)
		{
			if(spinner.getItemAtPosition(i).equals(settings.getString("eyeCandy", "None")))
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

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
	}
}

class EyeCandyListener implements AdapterView.OnItemSelectedListener
{

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
	
}