package server;

import data.Tweet;
import data.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

/**
 * this class handles client's message
 */

public class TaskHandler
{
    private JSONObject mapper;
    private ObjectOutputStream writer;
    private DataInputStream reader;

    public TaskHandler(JSONObject mapper, ObjectOutputStream writer, DataInputStream reader)
    {
        this.mapper = mapper;
        this.writer = writer;
        this.reader = reader;
    }
