package id.co.imastudio.myflexiblefragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbJava, rbPhp, rbJavascript, rbKotlin;
    private OnOptionDialogListener onOptionDialogListener;
    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button)view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button)view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = (RadioGroup)view.findViewById(R.id.rg_options);
        rbJava = (RadioButton)view.findViewById(R.id.rb_java);
        rbPhp = (RadioButton)view.findViewById(R.id.rb_PHP);
        rbJavascript = (RadioButton)view.findViewById(R.id.rb_javascript);
        rbKotlin = (RadioButton)view.findViewById(R.id.rb_kotlin);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    String lang = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_java:
                            lang = rbJava.getText().toString().trim();
                            break;
                        case R.id.rb_PHP:
                            lang = rbPhp.getText().toString().trim();
                            break;
                        case R.id.rb_javascript:
                            lang = rbJavascript.getText().toString().trim();
                            break;
                        case R.id.rb_kotlin:
                            lang = rbKotlin.getText().toString().trim();
                            break;
                    }
                    // User klik button pilih dan ini akan diekseusi
                    getOnOptionDialogListener().onOptionChoosen(lang);
                    getDialog().cancel();
                }
                break;
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}
