package persistence;

import model.Event;
import model.EventLog;
import model.Garden;
import org.json.JSONObject;

import java.io.*;

// Represents a writer that writes a JSON representation of garden to file. Using the edX JsonSerializationDemo as a
// base to use understand and template JsonWriter https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of garden to file
    public void write(Garden garden) {
        JSONObject json = garden.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        EventLog.getInstance().logEvent(new Event("garden saved to file"));
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}


