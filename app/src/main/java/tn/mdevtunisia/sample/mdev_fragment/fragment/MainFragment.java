package tn.mdevtunisia.sample.mdev_fragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import tn.mdevtunisia.sample.mdev_fragment.R;

/**
 * Created by adnenhamdouni on 01/04/2016.
 */
public class MainFragment extends Fragment {

    private TextView mTextview;
    private Button mButton;

    private Context mContext;

    //2. declare listener
    private static FragmentListener mListener;


    //3. add listener to consctructor
    public static MainFragment newInstance(FragmentListener listener) {
        MainFragment fragment = new MainFragment();
        mListener = listener;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity().getApplicationContext();

        View view = inflater.inflate(R.layout.fragment_main,
                container, false);

        initView(view);

        return view;

    }

    private void initView(View view) {
        mTextview =  (TextView) view.findViewById(R.id.textView);
        mTextview.setText("Hello Fragment :)!");

        mButton = (Button) view
                .findViewById(R.id.fragment_button_open_second_fragment);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4. Check Listener
                mListener.onClickPerform();

            }
        });
    }


    //1. declare Interface with onClickShowFragment method to implement
    public interface FragmentListener {
        public void onClickPerform();

    }
}