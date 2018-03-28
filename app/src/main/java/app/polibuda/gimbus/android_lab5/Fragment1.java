package app.polibuda.gimbus.android_lab5;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private AppCompatActivity appCompatActivity;
    private OnOptionPickListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            appCompatActivity = (AppCompatActivity) context;
            listener = (OnOptionPickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(appCompatActivity.toString() + " must implement OnOptionPickListener");
        }
    }

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio1: {
                listener.onOptionPick(1);
                break;
            }
            case R.id.radio2: {
                listener.onOptionPick(2);
                break;
            }
        }
    }

    public interface OnOptionPickListener {
        void onOptionPick(int option);
    }
}
