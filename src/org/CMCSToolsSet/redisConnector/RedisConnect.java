package org.CMCSToolsSet.redisConnector;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisConnect {
	
	private static RedisConnect redisCon = null ;
	
	private static Jedis jedis = null ;
	
	private String host = null ;
	
	private int port = 0 ;
	
	private String passwd = null ;
	
	private RedisConnect(String host, int port, String passwd){
		this.host = host;
		this.port = port;
		this.passwd = passwd;
		
		RedisConnect.jedis = new Jedis(new JedisShardInfo(this.host, this.port));
		RedisConnect.jedis.auth(this.passwd);
	}
	
	public static RedisConnect getInstance(String host, int port, String passwd){
		if(RedisConnect.redisCon == null){
			RedisConnect.redisCon = new RedisConnect(host, port, passwd);
		}
		return RedisConnect.redisCon ;
	}
	
	public static RedisConnect ChangeInstance(String host, int port, String passwd){
		RedisConnect.redisCon = new RedisConnect(host, port, passwd);
		return RedisConnect.redisCon;
	}

}
