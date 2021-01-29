package com.fcodex.ecommerce.NavFragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.fcodex.ecommerce.Activities.MainActivity;
import com.fcodex.ecommerce.R;
import com.fcodex.ecommerce.SharedPreference.PrefUtil;
import com.fcodex.ecommerce.SharedPreference.Sharedpreference;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;


public class SettingFragment extends Fragment {

    private View view;
    private Sharedpreference sharedpreference;
    private ImageView imageView;
    private TextView language;
    private Locale myLocale;
    private static final String SELECTED_LANGUAGE_ID = "Selected_language_ID";
    private static final String SELECTED_LANGUAGE = "Selected_language";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*fragmentSettingBinding = FragmentSettingBinding.inflate(getLayoutInflater());*/


        view = inflater.inflate(R.layout.fragment_setting, container, false);

        imageView = view.findViewById(R.id.darkMode);
        language = view.findViewById(R.id.language);

        sharedpreference = new Sharedpreference(getContext());
        if (sharedpreference.LoadDarkMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            imageView.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
            //setTheme(R.style.Theme_AppCompat_NoActionBar);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            //setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar);
        }

        onclicK();


        return view;

    }

    private void onclicK() {

        // for dark mode
        imageView.setOnClickListener(v -> {
            if (sharedpreference.LoadDarkMode()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                sharedpreference.SetDarkMode(false);

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                sharedpreference.SetDarkMode(true);

            }
        });

        language.setOnClickListener(v -> {
            alertBoxForLanguageSelection();
            /*final String[] listView = {"English", "اردو"};
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Choose Language");
            builder.setSingleChoiceItems(listView, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        setLocale("eng");
                        getActivity().recreate();
                    } else if (which == 1) {
                        setLocale("ur");
                        getActivity().recreate();
                    }

                    dialog.dismiss();
                }
            });
            AlertDialog mdial = builder.create();
            mdial.show();
        }*/
        });
    }

    private void alertBoxForLanguageSelection() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        View mView = getLayoutInflater().inflate(R.layout.language_dialog, null);
        ImageView dismiss = mView.findViewById(R.id.dismiss_btn);
        RadioGroup language = mView.findViewById(R.id.language_radio);
        language.check(Integer.parseInt(TextUtils.isEmpty(PrefUtil.getString(getActivity(), SELECTED_LANGUAGE_ID)) ? "0" :
                PrefUtil.getString(getActivity(), SELECTED_LANGUAGE_ID))
                == 0 ? R.id.english : Integer.parseInt(PrefUtil.getString(getActivity(), SELECTED_LANGUAGE_ID)));
        language.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.english:
                    PrefUtil.putString(getActivity(), SELECTED_LANGUAGE_ID, String.valueOf(R.id.english));
                    PrefUtil.putString(getActivity(), SELECTED_LANGUAGE, "en");
                    setLocale("en");
                    break;
                case R.id.spanish:
                    PrefUtil.putString(getContext(), SELECTED_LANGUAGE_ID, String.valueOf(R.id.spanish));
                    PrefUtil.putString(getActivity(), SELECTED_LANGUAGE, "ur");
                    setLocale("es");
                    break;

            }
        });
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        dismiss.setOnClickListener(v -> alertDialog.dismiss());
        alertDialog.getWindow()
                .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(getActivity(), MainActivity.class);

        refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(refresh);
    }

    /*private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getContext().getResources().updateConfiguration(configuration, getContext().getResources().getDisplayMetrics());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Setting", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Language", lang);
        editor.apply();

    }

    public void loadlanguage() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Setting", MODE_PRIVATE);
        String Language = sharedPreferences.getString("Language", "");
        setLocale(Language);
    }*/
}
