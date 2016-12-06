package com.example.saccerwin.todolist_group1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saccerwin.todolist_group1.adapter.TaskRecyclerAdapter;
import com.example.saccerwin.todolist_group1.constant.SimpleDividerItemDecoration;
import com.example.saccerwin.todolist_group1.objects.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View view;

    private TextView tvDay, tvMonthYear;

    private RecyclerView recyclerTask;
    private TaskRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Task> listTask = new ArrayList<Task>();

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        setDayMonthYear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);

        tvDay = (TextView) view.findViewById(R.id.tvDay);
        tvMonthYear = (TextView) view.findViewById(R.id.tvMonthYear);
        recyclerTask = (RecyclerView) view.findViewById(R.id.recyclerTask);

        setDayMonthYear();

        createView();

        // If the size of views will not change as the data changes.
        recyclerTask.setHasFixedSize(true);

        // Create divider between items
        recyclerTask.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        // Setting the LayoutManager.
        layoutManager = new LinearLayoutManager(getContext());
        recyclerTask.setLayoutManager(layoutManager);

        // Setting the adapter.
        adapter = new TaskRecyclerAdapter(getContext(), listTask, new TaskRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Task item) {
                if(item.isComplete() == false){
                    item.setComplete(true);
                } else {
                    item.setComplete(false);
                }
                for(int i = 0; i < listTask.size(); i++){
                    if(listTask.get(i).getId() == item.getId()){
                        listTask.set(i, item);
                        Toast.makeText(getActivity(), String.valueOf(listTask.get(i).isComplete()), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });

        recyclerTask.setAdapter(adapter);

        return view;
    }

    private void createView() {
        Task task = new Task();
        task.setId(1);
        task.setComplete(false);
        task.setDate("30-7-2016");
        task.setTime("9 - 11 am");
        task.setTitle("Di choi1");
        task.setDescription("Di choi");
        task.setLocation("1111");
        task.setGroup("Work");
        task.setAllday(true);
        listTask.add(task);

        Task task2 = new Task();
        task2.setId(2);
        task2.setComplete(true);
        task2.setDate("30-7-2016");
        task2.setTime("9 - 11 am");
        task2.setTitle("Di choi2");
        task2.setDescription("Di choi");
        task2.setLocation("1111");
        task2.setGroup("Work");
        task2.setAllday(true);
        listTask.add(task2);

        Task task3 = new Task();
        task3.setId(3);
        task3.setComplete(true);
        task3.setDate("30-7-2016");
        task3.setTime("9 - 11 am");
        task3.setTitle("Di choi3");
        task3.setDescription("Di choi");
        task3.setLocation("1111");
        task3.setGroup("Work");
        task3.setAllday(true);
        listTask.add(task3);

        Task task4 = new Task();
        task4.setId(4);
        task4.setComplete(true);
        task4.setDate("30-7-2016");
        task4.setTime("9 - 11 am");
        task4.setTitle("Di choi3");
        task4.setDescription("Di choi");
        task4.setLocation("1111");
        task4.setGroup("Work");
        task4.setAllday(true);
        listTask.add(task4);

        Task task5 = new Task();
        task5.setId(5);
        task5.setComplete(true);
        task5.setDate("30-7-2016");
        task5.setTime("9 - 11 am");
        task5.setTitle("Di choi3");
        task5.setDescription("Di choi");
        task5.setLocation("1111");
        task5.setGroup("Work");
        task5.setAllday(true);
        listTask.add(task5);

        Task task6 = new Task();
        task6.setId(6);
        task6.setComplete(true);
        task6.setDate("30-7-2016");
        task6.setTime("9 - 11 am");
        task6.setTitle("Di choi3");
        task6.setDescription("Di choi");
        task6.setLocation("1111");
        task6.setGroup("Work");
        task6.setAllday(true);
        listTask.add(task6);

        Task task7 = new Task();
        task7.setId(7);
        task7.setComplete(true);
        task7.setDate("30-7-2016");
        task7.setTime("9 - 11 am");
        task7.setTitle("Di choi3");
        task7.setDescription("Di choi");
        task7.setLocation("1111");
        task7.setGroup("Work");
        task7.setAllday(true);
        listTask.add(task7);

        //adapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * This function update tvDay tvMonthYear
     * return void
     */
    private void setDayMonthYear() {
        Date now = new Date();
        int tempDay = now.getDay();
        int tempDate = now.getDate();
        int tempMonth = now.getMonth();
        int tempYear = now.getYear() + 1900;
        String tempDateMonthYear = "";
        if (tempDay == 0) {
            tvDay.setText("Sunday");
        } else if (tempDay == 1) {
            tvDay.setText("Monday");
        } else if (tempDay == 2) {
            tvDay.setText("Tuesday");
        } else if (tempDay == 3) {
            tvDay.setText("wednesday");
        } else if (tempDay == 4) {
            tvDay.setText("Thursday");
        } else if (tempDay == 5) {
            tvDay.setText("Friday");
        } else {
            tvDay.setText("Saturday");
        }

        if (tempMonth == 0) {
            tempDateMonthYear += "January ";
        } else if (tempMonth == 1) {
            tempDateMonthYear += "February ";
        } else if (tempMonth == 2) {
            tempDateMonthYear += "March ";
        } else if (tempMonth == 3) {
            tempDateMonthYear += "April ";
        } else if (tempMonth == 4) {
            tempDateMonthYear += "May ";
        } else if (tempMonth == 5) {
            tempDateMonthYear += "June ";
        } else if (tempMonth == 6) {
            tempDateMonthYear += "July ";
        } else if (tempMonth == 7) {
            tempDateMonthYear += "August ";
        } else if (tempMonth == 8) {
            tempDateMonthYear += "September ";
        } else if (tempMonth == 9) {
            tempDateMonthYear += "October ";
        } else if (tempMonth == 10) {
            tempDateMonthYear += "November ";
        } else {
            tempDateMonthYear += "December ";
        }

        tempDateMonthYear += tempDate + ", ";
        tempDateMonthYear += tempYear;

        tvMonthYear.setText(tempDateMonthYear);

    }
}
