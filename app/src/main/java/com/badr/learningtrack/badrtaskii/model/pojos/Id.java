
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Id extends RealmObject {

    @SerializedName("name")
    @Expose
    @Setter
    @Getter
    private String name;
    @SerializedName("value")
    @Expose
    @Setter
    @Getter
    private String value;
}
