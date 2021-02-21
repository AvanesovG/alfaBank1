package com.example.demo.model;

import java.util.Arrays;

public class GifModel {

    private byte [] gif;

    public GifModel() {
    }

    public GifModel(byte[] gif) {
        this.gif = gif;
    }

    public byte[] getGif() {
        return gif;
    }

    public void setGif(byte[] gif) {
        this.gif = gif;
    }

    @Override
    public String toString() {
        return "GifModel{" +
                "gif=" + Arrays.toString(gif) +
                '}';
    }
}
