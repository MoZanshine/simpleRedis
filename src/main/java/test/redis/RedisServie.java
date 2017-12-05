package test.redis;

/**
 * 功能描述：封装底层方法方便调用
 * 类名：RedisServie
 * 作者：cd
 */
public interface RedisServie {
	/* 存缓存**/
	void add(String key,String value);
	/* 根据key修改**/
	void update(String key,String value);
	/* 根据key删除**/
	void del(String key);
	/* 根据key查询**/
	String query(String key);

}
