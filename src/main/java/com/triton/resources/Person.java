package com.triton.resources;


import java.lang.*;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.bson.types.ObjectId;

@Embedded
public class Person{
  
      @Id private ObjectId id;
  
      protected String name;
  
      @Embedded
      protected Address add;
  
      public String get_name(){
          return name;
      }
      
      public void set_name(String n){
          name=n;
      }
       
      
      public void set_add(Address a){
          add = a;
      }
      
      public Address get_add(){
          return add;
      }
      
      public String toString(){
    	  String s  = this.name +"  "+ this.add.toString();
    	  return s;
      }
  
  }

