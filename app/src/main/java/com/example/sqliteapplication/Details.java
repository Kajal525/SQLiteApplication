package com.example.sqliteapplication;

public class Details {

        String name, dob, contact;

        public Details(String name, String dob, String contact) {

            this.name = name;
            this.dob = dob;
            this.contact = contact;
        }

        public String getName() {
            return name;
        }

        public String getDob() {
            return dob;
        }

        public String getContact() {
            return contact;
        }
}
