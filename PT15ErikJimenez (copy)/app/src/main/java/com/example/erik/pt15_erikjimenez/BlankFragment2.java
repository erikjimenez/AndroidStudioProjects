package com.example.erik.pt15_erikjimenez;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BlankFragment2 extends Fragment {
    TextView editTextprimo;
    TextView contenedor;
    int numero;
    Button buttonfragment;
    private OnFragmentInteractionListener mListener;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        buttonfragment=(Button)v.findViewById(R.id.button2);
        editTextprimo=v.findViewById(R.id.editText2);
        contenedor=(TextView) v.findViewById(R.id.textView2);
        Log.d("Test","error-----509");
        buttonfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero=Integer.parseInt(String.valueOf(editTextprimo.getText().toString()));
                if(numero>=0) {
                    Log.d("test", numero + "------");
                    double primo = fibonacci(numero);
                    Log.d("test", primo + "------");
                    contenedor.setText(String.valueOf("Resultado: "+primo));
                }else{
                    Toast.makeText(getContext(),"Error, el num es neg.",Toast.LENGTH_LONG).show();
                }
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    private int fibonacci(int n){
//-
        if (n>1){
            return fibonacci(n-1) + fibonacci(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }else {
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
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
}
