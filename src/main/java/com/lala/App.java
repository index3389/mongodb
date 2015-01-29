package com.lala;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lala.domain.Person;
import com.lala.repository.PersonRepository;
import com.mongodb.WriteResult;

/**
 * Hello world!
 *
 */
@EnableMongoRepositories
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args).close();
    }
    
    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;

	public void run(String... args) throws Exception 
	{
		//insert();
		delete();
	}
	
	public void add()
	{
		personRepository.save(new Person("admin","管理员","admin@qq.com",0));	
		personRepository.save(new Person("baidu","百度","admin@baidu.com",0));	
		personRepository.save(new Person("qq","腾讯","qq@qq.com",1));	
		personRepository.save(new Person("sina","新浪","admin@sina.com.cn",1));
	}
	
	public void find2()
	{
		Person person = mongoTemplate.findOne(Query.query(Criteria.where("email").is("admin@sina.com.cn")), Person.class);
		System.out.println(ToStringBuilder.reflectionToString(person));
	}
	
	public void update()
	{
		mongoTemplate.updateMulti(Query.query(Criteria.where("role_parent").exists(true)), Update.update("role_parent","54ca2190f14c833ba98928fb"), "role");
	}
	
	public void delete()
	{
		WriteResult wr = mongoTemplate.remove(Query.query(Criteria.where("role_name").is("apahce")), "role");
		System.out.println(wr.getN());
	}
	
	public void insert()
	{
		Map<Object, Object> parent = new HashMap<>();
		parent.put("role_name", "web server");
		parent.put("role_desc", "web服务器");
		
		Map<Object, Object> role1 = new HashMap<>();
		role1.put("role_name", "nginx");
		role1.put("role_desc", "nginx是一个反向代理服务器");
		role1.put("role_parent", parent);
		
		Map<Object, Object> role2 = new HashMap<>();
		role2.put("role_name", "apache");
		role2.put("role_desc", "apache是Apache旗下的web服务器");
		role2.put("role_parent", parent);
		
		mongoTemplate.insert(parent, "role");
		mongoTemplate.insert(role1, "role");
		mongoTemplate.insert(role2, "role");
	}
	
	public void find()
	{
		Person person = personRepository.findOne("54ca16fff14cef4f445ac466");
		System.out.println(ToStringBuilder.reflectionToString(person));
		System.out.println("-----------------");
		List<Person> list = personRepository.findByStatus(1);
		for(Person p : list)
		{
			System.out.println(ToStringBuilder.reflectionToString(p));
		}
	}
}
