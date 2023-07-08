package com.example.doorsteptechnician;

public class TechnicianModel {
    private String tech_name,tech_shop_name,tech_shop_address,tech_phone_number,tech_wp_number;
    private String tech_Image;

    public TechnicianModel() {
    }

    public TechnicianModel(String tech_name, String tech_shop_name, String tech_shop_address, String tech_phone_number, String tech_wp_number, String tech_Image) {
        this.tech_name = tech_name;
        this.tech_shop_name = tech_shop_name;
        this.tech_shop_address = tech_shop_address;
        this.tech_phone_number = tech_phone_number;
        this.tech_wp_number = tech_wp_number;
        this.tech_Image = tech_Image;
    }

    public String getTech_name() {
        return tech_name;
    }

    public void setTech_name(String tech_name) {
        this.tech_name = tech_name;
    }

    public String getTech_shop_name() {
        return tech_shop_name;
    }

    public void setTech_shop_name(String tech_shop_name) {
        this.tech_shop_name = tech_shop_name;
    }

    public String getTech_shop_address() {
        return tech_shop_address;
    }

    public void setTech_shop_address(String tech_shop_address) {
        this.tech_shop_address = tech_shop_address;
    }

    public String getTech_phone_number() {
        return tech_phone_number;
    }

    public void setTech_phone_number(String tech_phone_number) {
        this.tech_phone_number = tech_phone_number;
    }

    public String getTech_wp_number() {
        return tech_wp_number;
    }

    public void setTech_wp_number(String tech_wp_number) {
        this.tech_wp_number = tech_wp_number;
    }

    public String getTech_Image() {
        return tech_Image;
    }

    public void setTech_Image(String tech_Image) {
        this.tech_Image = tech_Image;
    }
}
