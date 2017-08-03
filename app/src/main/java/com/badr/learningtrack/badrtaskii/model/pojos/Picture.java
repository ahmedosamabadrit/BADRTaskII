
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Picture extends RealmObject {

    @SerializedName("large")
    @Expose
    @Setter
    @Getter
    private String large;
    @SerializedName("medium")
    @Expose
    @Setter
    @Getter
    private String medium;
    @SerializedName("thumbnail")
    @Expose
    @Setter
    @Getter
    private String thumbnail;
}
