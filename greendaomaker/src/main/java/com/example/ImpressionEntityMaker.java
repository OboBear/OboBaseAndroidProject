package com.example;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by obo on 2017/3/8.
 * Email:obo.lin@dingtone.me
 */

public class ImpressionEntityMaker {
    public static void main( String []args) throws Exception {
        Schema schema = new Schema(2, "a.com.me.obo.greendaooldversion");
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

        Entity impressionEntity = schema.addEntity("ImpressionEntity");
        impressionEntity.addIdProperty();
        impressionEntity.addIntProperty("adType");
        impressionEntity.addStringProperty("offerId");
        impressionEntity.addStringProperty("md5Name");
        impressionEntity.addIntProperty("impression");
        impressionEntity.addIntProperty("click");
        impressionEntity.addIntProperty("adPostion");
        impressionEntity.addStringProperty("appID");
        impressionEntity.addStringProperty("placementID");
        impressionEntity.addStringProperty("offerName");
        impressionEntity.addLongProperty("timeLastUpdate");

    }
}
