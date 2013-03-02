package lwp;


import java.util.ArrayList;
import java.util.List;

import org.kamehamehaaa.android.livewallpaper.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LiveWallpaperSettings extends PreferenceActivity
    implements SharedPreferences.OnSharedPreferenceChangeListener {
	List<CharSequence> myList = new ArrayList<CharSequence>();
	List<CharSequence> myList2 = new ArrayList<CharSequence>();
	Spinner spinner, spinner_fr;
	ArrayAdapter <CharSequence>adapter, adapter2;
	
	
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.settings);
       spinner = (Spinner)this.findViewById(R.id.spinner1);
       spinner_fr = (Spinner)this.findViewById(R.id.spinner2);
        myList.add("Random");
        myList.add("Gradient");
        
        myList2.add("Pizza");
        
        adapter  = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,myList);
        adapter2 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,myList2);
        spinner.setAdapter(adapter);
        spinner_fr.setAdapter(adapter2);
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