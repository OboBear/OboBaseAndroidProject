package com.example;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String []args) throws Exception {
        Schema schema = new Schema(2, "com.me.obo.greendaooldversion");
        addNote(schema);
        new DaoGenerator().generateAll(schema, "./greendaooldversion/src/main/java");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty();
        note.addStringProperty("text");
        note.addStringProperty("comment");
        note.addDateProperty("date");
        note.addStringProperty("extra");
    }
}
