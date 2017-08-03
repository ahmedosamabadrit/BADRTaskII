
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Name extends RealmObject {

    @SerializedName("title")
    @Expose
    @Setter
    @Getter
    private String title;
    @SerializedName("first")
    @Expose
    @Setter
    @Getter
    private String first;
    @SerializedName("last")
    @Expose
    @Setter
    @Getter
    private String last;
}
