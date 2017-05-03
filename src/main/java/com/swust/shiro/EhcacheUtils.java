package com.swust.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

/**
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
@Component
public class EhcacheUtils<K,V>{
	
	@Autowired
	private EhCacheManager cacheManager;
	//Ĭ�ϵ�cache name
	private final String DEFAULT_CACHE_NAME="shiro_cache";
	private String cacheName;
	
	private Cache<K, V> cache;
	
	public String getCacheName() {
		return cacheName;
	}
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public EhcacheUtils(String cacheName){	
		this.cacheName=cacheName;
	}
	public EhcacheUtils(){}
	
	//��� cache name Ϊ�� ����Ĭ��Ϊ shiro ��cache ģ��
	public Cache<K,V> getCaChe(){
		cacheName = cacheName==null?DEFAULT_CACHE_NAME:cacheName;
		cache = cacheManager.getCache(cacheName);
		return cache;
	}
	
	public V getValue(K key){
		Cache<K, V> caChe = getCaChe();
		V v = caChe.get(key);
		return v;
	}
	//�õ� �û����е����е�key
	public Set<K> getKeys(){
		Set<K> keys = cache.keys();
		return keys;
	}
	
	public V put(K key,V value){
		 V v = cache.put(key, value);
		return v;
	}
	
	public V remove(K key){
		V v = cache.remove(key);
		return v;
	}
	
	public void clear(){
		cache.clear();
	}
	
	public int size(){
		return cache.size();
	}
	
	public Collection<V> values(){
		Collection<V> values = cache.values();
		return values;
	}
}
