package com.jhow.user_example_service.domain.entities;

import com.jhow.user_example_service.resources.repository.UserRepository;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    @PersistenceCreator
    public User(ObjectId _id, String name, String email, String phone) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    private User(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    @Id
    private ObjectId _id;
    private String name;
    private String email;
    private String phone;

    public static class Builder{
        private String name;
        private String email;
        private String phone;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
