package lwp;

import org.kamehamehaaa.android.livewallpaper.R;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdmobPreference extends Preference
{

    public AdmobPreference(Context context) {
        super(context, null);
    }

    public AdmobPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
            //override here to return the admob ad instead of a regular preference display
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.admob_preference, null);
    }

}
