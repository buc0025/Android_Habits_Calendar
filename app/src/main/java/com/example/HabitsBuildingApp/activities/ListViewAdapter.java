package com.example.HabitsBuildingApp.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HabitsBuildingApp.R;
import com.example.HabitsBuildingApp.managers.HabitManager;
import com.example.HabitsBuildingApp.managers.UtilityClass;
import com.example.HabitsBuildingApp.models.Habit;
import com.example.HabitsBuildingApp.models.WeekDayAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Habit> {

    public static Context context;
    private int resource;
    private List<Habit> habitList;
    private WeekDayAdapter weekDayAdapter;
    private LayoutInflater layoutInflater;
    private HabitManager habitManager;

    public ListViewAdapter(Context context, int resource, List<Habit> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        habitList = objects;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        weekDayAdapter = new WeekDayAdapter(context, position);
        String habitName = habitList.get(position).getHabit();
        String habitId = habitList.get(position).getHabitId();

        habitManager = new HabitManager(context);
        List<Long> epochTimes = habitManager.getHabitCompletedDates(habitId);

        // inflating recyclerView
        View view = layoutInflater.inflate(R.layout.habit_row, null, false);

        TextView streak = (TextView) view.findViewById(R.id.streakTextView);
        TextView habitTextView = (TextView) view.findViewById(R.id.habitName);
        TextView weekDayStreak = (TextView) view.findViewById(R.id.weekDayStreaks);

        streak.setText(UtilityClass.getStreak(epochTimes));
        habitTextView.setText(habitName);
        weekDayStreak.setText(UtilityClass.streakDayOrDays(Integer.valueOf(UtilityClass.getStreak(epochTimes))));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(weekDayAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}
