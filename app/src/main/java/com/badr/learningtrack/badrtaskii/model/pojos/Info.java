
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Info extends RealmObject {

    @SerializedName("seed")
    @Expose
    @Setter
    @Getter
    private String seed;
    @SerializedName("results")
    @Expose
    @Setter
    @Getter
    private int results;
    @SerializedName("page")
    @Expose
    @Setter
    @Getter
    private int page;
    @SerializedName("version")
    @Expose
    @Setter
    @Getter
    private String version;
}
