import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dizewei.pojo.User;
import com.dizewi.common.utils.DateUtil;
import com.dizewi.common.utils.EmailUtil;
import com.dizewi.common.utils.RandomUtil;
import com.dizewi.common.utils.StringUtil;

/**
 * @author 作者:dizewei
 * @version 创建时间：2020年3月2日 下午1:52:06 类功能说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	@Test
	public void jsonTest() throws ParseException {
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			// id
			user.setId(String.valueOf(i+1));
			// 随机姓名
			user.setName(StringUtil.randomChineseName());	
			// 随机性别
			user.setSex(StringUtil.randomSex());
			// 随机手机号
			int[] repeatRandomNumber = RandomUtil.repeatRandomNumber(0, 9, 9);
			String phone = "13";
			for (int j : repeatRandomNumber) {
				phone += j;
			}
			user.setPhone(phone);
			// 随机邮箱
			user.setEmilS(EmailUtil.getRandomLetterEmail(3, 20));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse("1949-01-01");
			Date date2 = sdf.parse("2001-12-31");
			Date randomDate = DateUtil.randomDate(date1, date2);
			String format = sdf.format(randomDate);
			user.setBirthday(format);
			list.add(user);
		}
		
		//获取开始时间
		long start = System.currentTimeMillis();
		
		redisTemplate.opsForList().leftPushAll("json", list.toArray());
		//获取结束时间
		long end = System.currentTimeMillis();
		System.out.println("json系列化方式");
		System.out.println("耗时"+(end-start));
		

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void jdkTest() throws ParseException {
		//获取开始时间
				long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			// id
			user.setId(String.valueOf(i+1));
			// 随机姓名
			user.setName(StringUtil.randomChineseName());	
			// 随机性别
			user.setSex(StringUtil.randomSex());
			// 随机手机号
			int[] repeatRandomNumber = RandomUtil.repeatRandomNumber(0, 9, 9);
			String phone = "13";
			for (int j : repeatRandomNumber) {
				phone += j;
			}
			user.setPhone(phone);
			// 随机邮箱
			user.setEmilS(EmailUtil.getRandomLetterEmail(3, 20));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse("1949-01-01");
			Date date2 = sdf.parse("2001-12-31");
			Date randomDate = DateUtil.randomDate(date1, date2);
			String format = sdf.format(randomDate);
			user.setBirthday(format);
			redisTemplate.opsForValue().set("jdk"+user.getId(), user);
		}
		
		//获取结束时间
		long end = System.currentTimeMillis();
		System.out.println("JDK系列化方式");
		System.out.println("耗时"+(end-start));
		

	}
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void hsahTest() throws ParseException {
		Map<String, Object> myMap = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			// id
			user.setId(String.valueOf(i+1));
			// 随机姓名
			user.setName(StringUtil.randomChineseName());	
			// 随机性别
			user.setSex(StringUtil.randomSex());
			// 随机手机号
			int[] repeatRandomNumber = RandomUtil.repeatRandomNumber(0, 9, 9);
			String phone = "13";
			for (int j : repeatRandomNumber) {
				phone += j;
			}
			user.setPhone(phone);
			// 随机邮箱
			user.setEmilS(EmailUtil.getRandomLetterEmail(3, 20));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse("1949-01-01");
			Date date2 = sdf.parse("2001-12-31");
			Date randomDate = DateUtil.randomDate(date1, date2);
			String format = sdf.format(randomDate);
			user.setBirthday(format);
			myMap.put("user"+user.getId(), user);
		}
		
		//获取开始时间
		long start = System.currentTimeMillis();
		
		redisTemplate.opsForHash().putAll("hash", myMap);
		//获取结束时间
		long end = System.currentTimeMillis();
		System.out.println("Hash类型");
		System.out.println("耗时"+(end-start));
		

	}

}
