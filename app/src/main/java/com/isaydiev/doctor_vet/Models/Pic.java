package com.isaydiev.doctor_vet.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 08.04.2017.
 */

public class Pic {
    @SerializedName("preview")
    private Preview preview;

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public static class Preview{
        @SerializedName("src")
        private String src;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}
