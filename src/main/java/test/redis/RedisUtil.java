package test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis���ӳ�
 * 
 * @author AK
 * 
 */
public final class RedisUtil {
	// Redis������IP
	private static String ADDR = "10.124.146.162";
	// Redis�Ķ˿ں�
	private static int PORT = 6379;
	// ��������
	private static String AUTH = "qsuan123unicomA";
	// ��������ʵ��������Ŀ��Ĭ��ֵΪ8��
	// ���ֵ�?-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�����ʱpool��״̬Ϊexhausted(�ľ�)��
	private static int MAX_ACTIVE = 1024;
	// ����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ��Ĭ��ֵҲ��8��
	private static int MAX_IDLE = 200;
	// �ȴ�������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
	private static long MAX_WAIT = 10000;
	// ����ӳ�ʱ��?
	private static int TIMEOUT = 10000;
	// ��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ����ǿ��õģ�?
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	/**
	 * ��ʼ��Redis���ӳ�
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
//			config.setMaxActive(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
//			config.setMaxWait(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡJedisʵ��
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �ͷ�jedis��Դ
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}
}
