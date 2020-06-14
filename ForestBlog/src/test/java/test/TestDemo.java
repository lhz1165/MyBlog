package test;

import com.liuyanzhao.ssm.blog.entity.Article;
import com.liuyanzhao.ssm.blog.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lhzlhz
 * @create 2020/3/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml","classpath:mybatis/mybatis-config.xml"})
public class TestDemo {
	@Autowired
	private ArticleMapper articleMapper;

	@Test
	public void test01(){

		List<Article> all = articleMapper.findAll(null);
		System.out.println(all);
	}
}
