package com.triton.resources;

import java.lang.*;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.bson.types.ObjectId;

@Embedded
public class Address{
  
  protected String street;
  protected String city;
  protected String postCode;
  protected String country;
  
  
  public void set_street(String s){
    street=s;
  }
  
  public void set_city(String c){
    city=c;
  }
  
  public void set_postCode(String pC){
    postCode=pC;
  }
  
  public void set_country(String c){
    country=c;
  }
  
  
  public String get_street(){
    return street;
  }
  
  public String get_city(){
    return city;
  }
  
  public String get_postCode(){
    return postCode;
  }
  
  public String get_country(){
    return country;
  }
  
  public String toString(){
	  return street+ " " + city + " " + postCode + " " + country;
  }
  
  }
