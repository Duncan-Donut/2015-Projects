package com.hitchhikingapps.thesuggestionbox;

/**
 * Created by Duncan on 3/31/2016.
 */
public class Suggestion {

    private int _id;
    private String _suggestion;

    public Suggestion(String _suggestion) {
        this._suggestion = _suggestion;
    }

    public int get_id() {
        return _id;
    }

    public String get_suggestion() {
        return _suggestion;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_suggestion(String _suggestion) {
        this._suggestion = _suggestion;
    }
}
