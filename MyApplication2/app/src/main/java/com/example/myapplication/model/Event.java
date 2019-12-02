package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private String name;
    private String location;
    private String type;
    private String period;
    private double price;
    private String contactName;
    private String contactPhone;
    private String description;
    private int picture;

    public Event() {
    }

    public Event(String name, String location, String type, String period, double price,
                 String contactName, String contactPhone, String description, int picture) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.period = period;
        this.price = price;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.description = description;
        this.picture = picture;
    }

    protected Event(Parcel in) {
        name = in.readString();
        location = in.readString();
        type = in.readString();
        period = in.readString();
        price = in.readDouble();
        contactName = in.readString();
        contactPhone = in.readString();
        description = in.readString();
        picture = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(type);
        dest.writeString(period);
        dest.writeDouble(price);
        dest.writeString(contactName);
        dest.writeString(contactPhone);
        dest.writeString(description);
        dest.writeInt(picture);
    }
}
