package com.alaa7amdy.travaladvidor.Model;

import android.net.Uri;

import java.util.ArrayList;

public class Post {
    private String postid;
    private String postimage0;
    private String postimage1;
    private String postimage2;
    private String postimage3;
    private String postimage4;
    private String postimage5;
    private String postimage6;
    private String postimage7;
    private String postimage8;
    private String postimage9;
    private String description;
    private String publisher;
    private String imagesNr;
    private String links ;

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public int getImagesNr() {
        int nr = Integer.parseInt(imagesNr);
        return nr;
    }

    public void setImagesNr(String imagesNr) {
        this.imagesNr = imagesNr;
    }

    public Post() {
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String postimage4, String postimage5, String postimage6, String postimage7, String postimage8, String postimage9, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.postimage4 = postimage4;
        this.postimage5 = postimage5;
        this.postimage6 = postimage6;
        this.postimage7 = postimage7;
        this.postimage8 = postimage8;
        this.postimage9 = postimage9;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String postimage4, String postimage5, String postimage6, String postimage7, String postimage8, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.postimage4 = postimage4;
        this.postimage5 = postimage5;
        this.postimage6 = postimage6;
        this.postimage7 = postimage7;
        this.postimage8 = postimage8;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }
    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String postimage4, String postimage5, String postimage6, String postimage7, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.postimage4 = postimage4;
        this.postimage5 = postimage5;
        this.postimage6 = postimage6;
        this.postimage7 = postimage7;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String postimage4, String postimage5, String postimage6, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.postimage4 = postimage4;
        this.postimage5 = postimage5;
        this.postimage6 = postimage6;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String postimage4, String postimage5, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.postimage4 = postimage4;
        this.postimage5 = postimage5;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String postimage4, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.postimage4 = postimage4;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String postimage3, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.postimage3 = postimage3;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String postimage2, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.postimage2 = postimage2;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String postimage1, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.postimage1 = postimage1;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public Post(String postid, String postimage0, String description, String publisher, String imagesNr ,String links) {
        this.postid = postid;
        this.postimage0 = postimage0;
        this.description = description;
        this.publisher = publisher;
        this.imagesNr = imagesNr;
        this.links = links;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostimage0() {
        return postimage0;
    }

    public void setPostimage0(String postimage0) {
        this.postimage0 = postimage0;
    }

    public String getPostimage1() {
        return postimage1;
    }

    public void setPostimage1(String postimage1) {
        this.postimage1 = postimage1;
    }

    public String getPostimage2() {
        return postimage2;
    }

    public void setPostimage2(String postimage2) {
        this.postimage2 = postimage2;
    }

    public String getPostimage3() {
        return postimage3;
    }

    public void setPostimage3(String postimage3) {
        this.postimage3 = postimage3;
    }

    public String getPostimage4() {
        return postimage4;
    }

    public void setPostimage4(String postimage4) {
        this.postimage4 = postimage4;
    }

    public String getPostimage5() {
        return postimage5;
    }

    public void setPostimage5(String postimage5) {
        this.postimage5 = postimage5;
    }

    public String getPostimage6() {
        return postimage6;
    }

    public void setPostimage6(String postimage6) {
        this.postimage6 = postimage6;
    }

    public String getPostimage7() {
        return postimage7;
    }

    public void setPostimage7(String postimage7) {
        this.postimage7 = postimage7;
    }

    public String getPostimage8() {
        return postimage8;
    }

    public void setPostimage8(String postimage8) {
        this.postimage8 = postimage8;
    }

    public String getPostimage9() {
        return postimage9;
    }

    public void setPostimage9(String postimage9) {
        this.postimage9 = postimage9;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public ArrayList<Uri> getimages(){

        ArrayList<Uri> slider_image_list = new ArrayList<>();
        switch (getImagesNr()){
            case 1 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                break;
            case 2 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                break;
            case 3 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                break;
            case 4 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                break;
            case 5 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                slider_image_list.add(Uri.parse(getPostimage4()));
                break;
            case 6 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                slider_image_list.add(Uri.parse(getPostimage4()));
                slider_image_list.add(Uri.parse(getPostimage5()));
                break;
            case 7 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                slider_image_list.add(Uri.parse(getPostimage4()));
                slider_image_list.add(Uri.parse(getPostimage5()));
                slider_image_list.add(Uri.parse(getPostimage6()));
                break;
            case 8 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                slider_image_list.add(Uri.parse(getPostimage4()));
                slider_image_list.add(Uri.parse(getPostimage5()));
                slider_image_list.add(Uri.parse(getPostimage6()));
                slider_image_list.add(Uri.parse(getPostimage7()));
                break;
            case 9 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                slider_image_list.add(Uri.parse(getPostimage4()));
                slider_image_list.add(Uri.parse(getPostimage5()));
                slider_image_list.add(Uri.parse(getPostimage6()));
                slider_image_list.add(Uri.parse(getPostimage7()));
                slider_image_list.add(Uri.parse(getPostimage8()));
                break;
            case 10 :
                slider_image_list.add(Uri.parse(getPostimage0()));
                slider_image_list.add(Uri.parse(getPostimage1()));
                slider_image_list.add(Uri.parse(getPostimage2()));
                slider_image_list.add(Uri.parse(getPostimage3()));
                slider_image_list.add(Uri.parse(getPostimage4()));
                slider_image_list.add(Uri.parse(getPostimage5()));
                slider_image_list.add(Uri.parse(getPostimage6()));
                slider_image_list.add(Uri.parse(getPostimage7()));
                slider_image_list.add(Uri.parse(getPostimage8()));
                slider_image_list.add(Uri.parse(getPostimage9()));
                break;


        }


        return slider_image_list;
    }


}
