package com.hitchhikingapps.thesuggestionbox;

/**
 * Created by Duncan on 3/29/2016.
 */
public class Complaint {

    private int _id;
    private String _complaint;

    public Complaint(String _complaint) {
        this._complaint = _complaint;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_complaint(String _complaint) {
        this._complaint = _complaint;
    }

    public int get_id() {
        return _id;
    }

    public String get_complaint() {
        return _complaint;
    }
}
