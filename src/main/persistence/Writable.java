package persistence;

import org.json.JSONObject;

// based to use understand https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public interface Writable {

    //EFFECTS: returns this as JSON Object
    JSONObject toJson();
}
