package com.example.appkfc.models;

import java.io.Serializable;

public class RegistroModel implements Serializable {
    String pass,correo;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
