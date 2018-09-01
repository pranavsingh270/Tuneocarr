package com.example.pranav.tuneocarr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class ContactFragment extends android.support.v4.app.Fragment {
    CircularProgressButton btn_submit;
    EditText edit_name,edit_email,edit_phone,edit_comments;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contact_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        btn_submit=(CircularProgressButton) getActivity().findViewById(R.id.submit);
        edit_name=(EditText)getActivity().findViewById(R.id.edit_name);
        edit_email=(EditText)getActivity().findViewById(R.id.edit_email);
        edit_phone=(EditText)getActivity().findViewById(R.id.edit_phone);
        edit_comments=(EditText)getActivity().findViewById(R.id.edit_comments);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateInput()) {
                    RequestQueue MyRequestQueue = Volley.newRequestQueue(getActivity());
//                String url = "http://192.168.56.1/newfolder/v2/demo.php";
                    String url = "http://carmender.in/demo.php";
                    StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("Response-->" + response);
                            //This code is executed if the server responds, whether or not the response contains data.
                            //The String 'response' contains the server's response.
                            callDialog();
                        }
                    }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //This code is executed if there is an error.
                        }
                    }) {
                        protected Map<String, String> getParams() {
                            Map<String, String> MyData = new HashMap<String, String>();
                            MyData.put("name", edit_name.getText().toString());
                            MyData.put("email", edit_email.getText().toString());
                            MyData.put("phone", edit_phone.getText().toString());
                            MyData.put("comments", edit_comments.getText().toString());//Add the data you'd like to send to the server.
                            return MyData;
                        }
                    };


                    MyRequestQueue.add(MyStringRequest);
                }

            }

        });
    }
    public void callDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Thanks "+edit_name.getText().toString()+" for contacting us. We will be in touch with you very soon");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        edit_name.setText("");
        edit_email.setText("");
        edit_phone.setText("");
        edit_comments.setText("");
    }
    public boolean validateInput(){

        if(edit_name.getText().toString().equals("")){
            edit_name.setError("Name cannot be left blank");
        }
        else if(edit_email.getText().toString().equals("")){
            edit_name.setError("Email cannot be left blank");
        }
        else if(edit_phone.getText().toString().equals("")){
            edit_name.setError("Phone cannot be left blank");
        }
        else if(edit_comments.getText().toString().equals("")){
            edit_name.setError("Comments cannot be left blank");
        }
        String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                "\\@" +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                "(" +

                "\\." +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                ")+";


        String email = edit_email.getText().toString();

        Matcher matcher= Pattern.compile(validemail).matcher(email);


        if (matcher.matches()){
           // Toast.makeText(getActivity(),"True",Toast.LENGTH_LONG).show();
            return true;

        }
        else {
         //   Toast.makeText(getActivity(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
            edit_email.setError("Enter valid Email");
            return false;
        }


    }
    }

