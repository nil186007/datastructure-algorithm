package com.nilesh.practice.arcsium;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Solution {

    public static void main(String[] args) {

        String urlString = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
        Gson gson = new Gson();


        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Contacts [] contacts = gson.fromJson(reader,  Contacts[].class);

            for(Contacts c : contacts){
                System.out.println(c.getID());
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //HttpURLConnection con = ()


    }


   class Contacts {
        private long id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String website;
        private Company company;

        public long getID() { return id; }
        public void setID(long value) { this.id = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public String getUsername() { return username; }
        public void setUsername(String value) { this.username = value; }

        public String getEmail() { return email; }
        public void setEmail(String value) { this.email = value; }

        public Address getAddress() { return address; }
        public void setAddress(Address value) { this.address = value; }

        public String getWebsite() { return website; }
        public void setWebsite(String value) { this.website = value; }

        public Company getCompany() { return company; }
        public void setCompany(Company value) { this.company = value; }
    }

// Address.java


     class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public String getStreet() { return street; }
        public void setStreet(String value) { this.street = value; }

        public String getSuite() { return suite; }
        public void setSuite(String value) { this.suite = value; }

        public String getCity() { return city; }
        public void setCity(String value) { this.city = value; }

        public String getZipcode() { return zipcode; }
        public void setZipcode(String value) { this.zipcode = value; }

        public Geo getGeo() { return geo; }
        public void setGeo(Geo value) { this.geo = value; }
    }

// Geo.java


     class Geo {
        private String lat;
        private String lng;

        public String getLat() { return lat; }
        public void setLat(String value) { this.lat = value; }

        public String getLng() { return lng; }
        public void setLng(String value) { this.lng = value; }
    }

// Company.java


     class Company {
        private String name;
        private String basename;

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public String getBasename() { return basename; }
        public void setBasename(String value) { this.basename = value; }
    }

}
