
package com.badr.learningtrack.badrtaskii.model.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.Getter;
import lombok.Setter;

@RealmClass
public class Login extends RealmObject {

    @SerializedName("username")
    @Expose
    @Setter
    @Getter
    private String username;
    @SerializedName("password")
    @Expose
    @Setter
    @Getter
    private String password;
    @SerializedName("salt")
    @Expose
    @Setter
    @Getter
    private String salt;
    @SerializedName("md5")
    @Expose
    @Setter
    @Getter
    private String md5;
    @SerializedName("sha1")
    @Expose
    @Setter
    @Getter
    private String sha1;
    @SerializedName("sha256")
    @Expose
    @Setter
    @Getter
    private String sha256;
}
