package de.berlios.sventon.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

public class SventonCache {

  /** The cache manager instance. */
  private CacheManager cacheManager = null;

  /** The cache instance. */
  private Cache cache = null;

  /** Logger for this class and subclasses */
  protected final Log logger = LogFactory.getLog(getClass());

  /** Sventon cache name. */
  public static final String CACHE_NAME = "sventonCache";

  /** Singelton instance of the factory. */
  public static final SventonCache INSTANCE = new SventonCache();

  /**
   * Private contructor.
   * As this is a singleton instance it must not
   * be extended or created from the outside.
   * @throws RuntimeException if unable to create cache instance.
   */
  private SventonCache() {
    try {
      init();
    } catch(CacheException ce) {
      throw new RuntimeException("Unable to create cache instance.");
    }
  }

  /**
   * Initializes the cache.
   * @throws CacheException if cache initialization error occur.
   */
  private synchronized void init() throws CacheException {
    cacheManager = CacheManager.getInstance();
    cache = cacheManager.getCache(CACHE_NAME);
  }

  /**
   * Puts an object into the cache.
   * @param key The cache key - <code>toString</code> will be executed on the key.
   * @param value The object to cache.
   * @throws CacheException if unable to cache object.
   */
  public void put(final Object key, final Object value) throws CacheException {
    String cacheKey = key.toString();
    Element element = new Element(cacheKey, (Serializable) value);
    cache.put(element);
  }

  /**
   * Gets an object from the cache.
   * @param key The key to the object to get.
   * @return The cached object.
   * @throws CacheException if unable to get object from cache.
   */
  public Object get(final Object key) throws CacheException {
    String cacheKey = key.toString();
    Element element = cache.get(cacheKey);
    return element.getValue();
  }

  /**
   * @return Current memory size of the cache.
   * @throws CacheException if unable to get memory size.
   */
  public long getMemorySize() throws CacheException {
    return cache.calculateInMemorySize();
  }

  /**
   * @return The cache hit count.
   * @throws CacheException if unable to get cache hit count.
   */
  public long getHitCount() throws CacheException {
    return cache.getHitCount();
  }

}