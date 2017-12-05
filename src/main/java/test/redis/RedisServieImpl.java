package test.redis;
public class RedisServieImpl implements RedisServie {

	public void add(String key, String value) {
		RedisUtil.getJedis().set(key, value);
	}

	public void update(String key, String value) {
		del(key);
		add(key, value);
	}

	public void del(String key) {
		RedisUtil.getJedis().del(key);

	}

	public String query(String key) {
		String string = RedisUtil.getJedis().get(key);
		return string;
	}

	public static void main(String[] args) {
		RedisServie service =new RedisServieImpl();
		service.add("test", "testvalue");
		String query = service.query("test");
		System.out.println(query);
	}
}
