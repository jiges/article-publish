package com.nongrj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AhampCmsAdminApplicationTests {

	@Test
	public void contextLoads() {
		Document doc = Jsoup.parse("<p>文章内容</p><p style=\"text-align: center\"><img src=\"/image/20180816/1534386819267001802.png\" alt=\"1534386819267001802.png\"/></p><p><br/></p>");
		Elements imgs = doc.select("img");
		System.out.println(imgs.get(0).attr("src"));
		Elements p = doc.select("p");
		System.out.println(p.get(0).text());
	}

}
