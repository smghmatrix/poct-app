package com.example.myapplication;

import androidx.camera.core.ImageProxy;

import java.util.ArrayList;

public class localStorage {
    private int numberImage;
    private ArrayList<ImageProxy> imageProxies;

    public localStorage() {
        imageProxies = new ArrayList<>();
        numberImage = 0 ;
    }
    public void addNumber(){
        numberImage++;
    }
    public void addImage(ImageProxy imageProxy){
        imageProxies.add(imageProxy);
    }

    public String  getNumberString() {
        return numberImage + "";
    }

    public ArrayList<ImageProxy> getImageProxies() {
        return imageProxies;
    }

    public int getNumberImage() {
        return numberImage;
    }

    public void setNumberImage(int numberImage) {
        this.numberImage = numberImage;
    }

    public void setImageProxies(ArrayList<ImageProxy> imageProxies) {
        this.imageProxies = imageProxies;
    }
}
