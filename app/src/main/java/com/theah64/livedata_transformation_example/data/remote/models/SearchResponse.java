package com.theah64.livedata_transformation_example.data.remote.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse extends BaseAPIResponse<SearchResponse.Data> {

    public SearchResponse(boolean error, String message, Data data) {
        super(error, message, data);
    }

    public static class Data {

        @SerializedName("users")
        private final List<User> users;


        public Data(List<User> users) {
            this.users = users;
        }

        public List<User> getUsers() {
            return users;
        }

    }

    public static class User {

        @SerializedName("name")
        private final String name;

        @SerializedName("image")
        private final String image;


        public User(String name, String image) {
            this.name = name;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }

    }
}
