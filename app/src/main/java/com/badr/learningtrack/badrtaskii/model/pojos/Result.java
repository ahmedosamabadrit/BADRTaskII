
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Result extends RealmObject {

    @SerializedName("gender")
    @Expose
    @Setter
    @Getter
    private String gender;
    @SerializedName("name")
    @Expose
    @Setter
    @Getter
    private Name name;
    @SerializedName("location")
    @Expose
    @Setter
    @Getter
    private Location location;
    @SerializedName("email")
    @Expose
    @Setter
    @Getter
    private String email;
    @SerializedName("login")
    @Expose
    @Setter
    @Getter
    private Login login;
    @SerializedName("dob")
    @Expose
    @Setter
    @Getter
    private String dob;
    @SerializedName("registered")
    @Expose
    @Setter
    @Getter
    private String registered;
    @SerializedName("phone")
    @Expose
    @Setter
    @Getter
    private String phone;
    @SerializedName("cell")
    @Expose
    @Setter
    @Getter
    private String cell;
    @SerializedName("id")
    @Expose
    @Setter
    @Getter
    private Id id;
    @SerializedName("picture")
    @Expose
    @Setter
    @Getter
    private Picture picture;
    @SerializedName("nat")
    @Expose
    @Setter
    @Getter
    private String nat;

    @PrimaryKey
    @Expose
    @Setter
    @Getter
    private int usersID;
}
