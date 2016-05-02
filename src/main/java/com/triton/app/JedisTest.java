package com.triton.app;

import redis.clients.jedis.Jedis;

public class JedisTest {
	public static void main(String[] args) {
		String cacheKey = "languages";
		Jedis jedis = new Jedis("localhost");
		// Adding a set as value

		jedis.sadd(cacheKey, "Java");
		jedis.sadd(cacheKey, "C#");
		jedis.sadd(cacheKey, "Python");// SADD
		
		String value = "Useless";
		String valuable = "Nice";
		// Getting all values in the set: SMEMBERS
		System.out.println("Languages: " + jedis.smembers(cacheKey));
		// Adding new values
		jedis.sadd(cacheKey, "Java");
		jedis.sadd(cacheKey, "Ruby");
		jedis.sadd(value, "Java");
		jedis.sadd(value, "Cobol");
		jedis.sadd(value, "Javascript");
		jedis.sadd(value, "PHP");		
		
		jedis.sadd(valuable,"Ada");
		jedis.sadd(valuable,"C#");
		jedis.sadd(valuable,"Ocaml");
		jedis.sadd(valuable,"C");
		jedis.sadd(valuable,"Python");
		jedis.sadd(valuable,"C++");
		// Getting the values... it doesn't allow duplicates
		System.out.println("Languages: " + jedis.smembers(cacheKey));
		System.out.println("Uesless languages: " + jedis.smembers(value));
		System.out.println("Nice languages: " + jedis.smembers(valuable));

		

	}
}
