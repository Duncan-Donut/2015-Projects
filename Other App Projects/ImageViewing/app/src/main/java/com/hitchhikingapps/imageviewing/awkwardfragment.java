package com.hitchhikingapps.imageviewing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class awkwardfragment extends Fragment{

    hello activityCommander;

    public interface hello{
        public void changer(int a);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity b=(Activity) context;
        try{
            activityCommander = (hello) b;
        }catch(ClassCastException e){
            throw new ClassCastException(b.toString());
        }
    }

    Button frog,octopus,giraffe;
    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.awkward,container,false);

        frog = (Button) view.findViewById(R.id.frog);
        giraffe = (Button) view.findViewById(R.id.giraffe);
        octopus = (Button) view.findViewById(R.id.octopus);

       frog.setOnClickListener (
            new View.OnClickListener() {
                public void onClick(View view) {
                    activityCommander.changer(1);
                }
            }
       );
        giraffe.setOnClickListener (
                new View.OnClickListener() {
                    public void onClick(View view) {
                        activityCommander.changer(2);
                    }
                }
        );

        octopus.setOnClickListener (
                new View.OnClickListener() {
                    public void onClick(View view) {
                        activityCommander.changer(3);
                    }
                }
        );

        return view;
    }


}
