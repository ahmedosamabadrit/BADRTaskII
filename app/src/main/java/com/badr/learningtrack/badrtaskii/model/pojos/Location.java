
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Location extends RealmObject {

    @SerializedName("street")
    @Expose
    @Setter
    @Getter
    private String street;
    @SerializedName("city")
    @Expose
    @Setter
    @Getter
    private String city;
    @SerializedName("state")
    @Expose
    @Setter
    @Getter
    private String state;
//    @SerializedName("postcode")
//    @Expose
//    private int postcode;
}
