package edu.jsu.mcis.cs408.tablayoutdemo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class FragmentTwo extends Fragment implements TabFragment {

    private final String title = "Tips";
    private TextView output;
    private EditText textBill;
    private EditText textPercent;
    private EditText textNumPeople;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        output = (TextView) view.findViewById(R.id.output);
        textBill = (EditText) view.findViewById(R.id.mealCost);
        textPercent = (EditText) view.findViewById(R.id.tipPercent);
        textNumPeople = (EditText) view.findViewById(R.id.numPeople);
        view.findViewById(R.id.calculateBtn).setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        double bill;
        double percent;
        double numPeople;
        double costPerPerson;
        Toast toast = Toast.makeText(getActivity(), "Please ensure that no fields are empty and the values are numeric.", Toast.LENGTH_SHORT);
        DecimalFormat df = new DecimalFormat("#.00");



        try {

            bill = Double.parseDouble(textBill.getText().toString());
            percent = Double.parseDouble(textPercent.getText().toString());
            numPeople = Double.parseDouble(textNumPeople.getText().toString());
            percent = percent * .01;
            costPerPerson = (bill + (bill * percent)) / numPeople;
            costPerPerson = Double.parseDouble(df.format(costPerPerson));


            output.setText("$" + costPerPerson);
        }

        catch(Exception e){
            toast.show();
        }
    }

    public String getTabTitle() { return title; }

}