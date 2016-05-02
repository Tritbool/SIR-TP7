package com.triton.resources;

import java.lang.*;
import java.util.*;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.bson.types.ObjectId;


@Entity
public class Article{
  
      @Id private ObjectId id;
  
      protected String name;
      protected int stars;
      
      @Embedded
      protected Collection<Person> buyers;
 
      public Article(){
          buyers = new ArrayList<Person>();
      }
      
      public String get_name(){
          return name;
      }
      
      public void set_name(String n){
          name=n;
      }
      
      public int get_start(){
          return stars;
      }
      
      public void set_stars(int s){
          stars=s;
      }   
      
      public Collection<Person> get_buyers(){
          return buyers;
      }
  
  }
