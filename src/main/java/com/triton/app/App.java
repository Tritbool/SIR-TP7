package com.triton.app;

import com.triton.resources.*;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.bson.types.ObjectId;
import org.mongodb.morphia.*;
import com.mongodb.MongoClient;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
      
      final Morphia morphia = new Morphia();

      // tell Morphia where to find your classes
      // can be called multiple times with different packages or classes
      morphia.mapPackage("com.triton.resources.*");

      // create the Datastore connecting to the default port on the local host
      final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_base");
      datastore.ensureIndexes();
      
      
      Address add = new Address();
      
      add.set_street("Rue du love");
      add.set_city("Ouarzazate");
      add.set_postCode("1000");
      add.set_country("Maroc");
      
      
      Address add1 = new Address();
      
      add1.set_street("Bd yolo");
      add1.set_city("Zyon");
      add1.set_postCode("12345");
      add1.set_country("France");
      
      Person p = new Person();
      p.set_name("Triton");
      p.set_add(add);
 
      Person p1 = new Person();
      p1.set_name("Huguette");
      p1.set_add(add);      
      
      Person p2 = new Person();
      p2.set_name("LeFou");
      p2.set_add(add1);     
      
      Article a = new Article();
      a.set_name("Candelabre imperial");
      a.set_stars(5);
      a.get_buyers().add(p);   
      a.get_buyers().add(p1);
      datastore.save(a);
      
      Article a1 = new Article();
      a1.set_name("Ciseaux deluxe");
      a1.set_stars(3);
      a1.get_buyers().add(p1);   
      datastore.save(a1);
      
      
      Article a2 = new Article();
      a2.set_name("Cheminee de table");
      a2.set_stars(1);
      a2.get_buyers().add(p2);   
      datastore.save(a2);
      
      for (Article e : datastore.find(Article.class)){
  	    	
 			 e.get_buyers().forEach((person) -> {System.out.println(e.get_name() + " " + e.get_start() + " " + person.toString());});
      }
    }
     
    
}
