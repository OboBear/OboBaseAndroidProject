package com.me.obo.greendaoproject.db;

/**
 * Created by obo on 2017/3/7.
 * Email:obo.lin@dingtone.me
 */

import org.greenrobot.greendao.converter.PropertyConverter;

public class NoteTypeConverter implements PropertyConverter<NoteType, String> {
    @Override
    public NoteType convertToEntityProperty(String databaseValue) {
        return NoteType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(NoteType entityProperty) {
        return entityProperty.name();
    }
}