package test.redis;

/**
 * ������������װ�ײ㷽���������
 * ������RedisServie
 * ���ߣ�cd
 */
public interface RedisServie {
	/* �滺��**/
	void add(String key,String value);
	/* ����key�޸�**/
	void update(String key,String value);
	/* ����keyɾ��**/
	void del(String key);
	/* ����key��ѯ**/
	String query(String key);

}
