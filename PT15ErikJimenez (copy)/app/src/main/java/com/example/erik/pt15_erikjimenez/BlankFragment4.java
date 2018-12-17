package com.example.erik.pt15_erikjimenez;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
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
 * {@link BlankFragment4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BlankFragment4 extends Fragment {
    TextView editTextprimo;
    TextView contenedor;
    int numero;
    Button buttonfragment;
    private OnFragmentInteractionListener mListener;

    public BlankFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewask= inflater.inflate(R.layout.fragment_blank_fragment4, container, false);
        buttonfragment=(Button)viewask.findViewById(R.id.buttonask2);
        editTextprimo=viewask.findViewById(R.id.editTextask2);
        contenedor=viewask.findViewById(R.id.textViewask2);
        buttonfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ExAsyncTask().execute();
            }
        });
        return viewask;
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
    //entrada      //salida
    private class ExAsyncTask extends AsyncTask<Integer,Integer,String> {
        @Override
        protected void onPreExecute() {//the first metod , incializar variables
            super.onPreExecute();
            Log.d("test","asd------");
        }
        @Override
        protected String doInBackground(Integer... integers) {
            Log.d("test","----⁻----");
            String camel = editTextprimo.getText().toString();
            double numero=fibonacci(Integer.parseInt(camel));
            return String.valueOf(numero);
        }
        @Override
        protected void onPostExecute(String aVoid) {
            Log.d("test",aVoid+"---505.----");
            contenedor.setText(String.valueOf("Resultado: "+aVoid));
            //valor calculado
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getContext(),"Toast,(cancelled)",Toast.LENGTH_LONG).show();
        }
    }
}
