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
 * {@link BlankFragment3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BlankFragment3 extends Fragment {
    TextView editTextprimo;
    TextView contenedor;
    int numero;
    Button buttonfragment;
    View viewask;
    private OnFragmentInteractionListener mListener;

    public BlankFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewask= inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        buttonfragment=(Button)viewask.findViewById(R.id.buttonask);
        editTextprimo=viewask.findViewById(R.id.editTextask);
        contenedor=viewask.findViewById(R.id.textViewask);
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
    public static Boolean esPrimo(int numero)
    {
        Boolean esPrimoActual = true;
        if(numero<2)
        {
            esPrimoActual = false;
        }
        else
        {
            for(int x=2; x<numero; x++)
            {
                if( numero%x==0 ){esPrimoActual = false;break;}
            }
        }
        return esPrimoActual;
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
    private class ExAsyncTask extends AsyncTask<Void,Integer,String> implements com.example.erik.pt15_erikjimenez.ExAsyncTask {

        @Override
        protected void onPreExecute() {//the first metod , incializar variables
            Log.d("test","error------pre");
            super.onPreExecute();
            Log.d("test","asd------");
        }
        @Override
        protected String doInBackground(Void... voids) {
            Log.d("test","----⁻----");
            String camel = editTextprimo.getText().toString();
            boolean numero=esPrimo(Integer.parseInt(camel));
            return String.valueOf(numero);
        }
        @Override
        protected void onPostExecute(String aVoid) {

            Log.d("test",aVoid+"---505.----");
            contenedor.setText(String.valueOf("El num es primo: "+aVoid));
            //valor calculado
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getContext(),"Cliquem botto del fragment 2",Toast.LENGTH_LONG).show();
        }
    }
}
