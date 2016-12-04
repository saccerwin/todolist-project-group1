package com.example.saccerwin.todolist_group1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;


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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);

        tvDay = (TextView) view.findViewById(R.id.tvDay);
        tvMonthYear = (TextView) view.findViewById(R.id.tvMonthYear);

        setDayMonthYear();

        return view;
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
