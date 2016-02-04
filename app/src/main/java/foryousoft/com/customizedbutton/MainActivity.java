package foryousoft.com.customizedbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okButton = (Button) findViewById(R.id.ok);
        addListeners();
    }

    private void addListeners() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int checkedId) {

                                                      if (R.id.enabled == checkedId)
                                                          setButtonState(false, false, true);
                                                      else if (R.id.disabled == checkedId)
                                                          setButtonState(false, false, false);
                                                      else if (R.id.pressed == checkedId)
                                                          setButtonState(true, true, true);
                                                      else if (R.id.focused == checkedId)
                                                          setButtonState(false, true, true);
                                                  }
                                              }
        );
        radioGroup.check(R.id.enabled);
    }

    private void setButtonState(boolean pressed, boolean focused, boolean enabled) {

        okButton.setPressed(pressed);
        okButton.setEnabled(enabled);
        okButton.setFocusableInTouchMode(focused);
        if (focused)
            okButton.requestFocus();
        else
            okButton.clearFocus();
    }
}
