package com.example.lenovo.food;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c=Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min=c.get(Calendar.MINUTE);
        TimePickerDialog dialog=new TimePickerDialog(getActivity(),this,hour,min,false);
        return dialog;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int min) {
        ((activity_seat_selection)getActivity()).onTimeSet(hour,min);
        TextView t=(TextView)getActivity().findViewById(R.id.textime);
        t.setText(String.valueOf(hour)+": "+String.valueOf(min+" pm"));
    }


}
