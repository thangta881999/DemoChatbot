package com.TP.controller.admin;

import java.io.IOException;
import java.lang.Thread.State;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TP.Respone.CrawlerResponse;
import com.TP.entity.DanhMucSanPham;
import com.TP.helper.Helper;
import com.TP.service.CrawlerService;
import com.TP.service.DanhMucService;

import net.bytebuddy.implementation.bytecode.Throw;

@Controller
@RequestMapping("admin/crawler")
public class CrawlerController {
	CrawlerService crawler;
	@Autowired
	DanhMucService danhMucService;
	@SuppressWarnings("deprecation")
	@GetMapping
	public String Default(ModelMap modelMap) throws IOException {
		Helper.crawlerBy=1;
		if (crawler==null)
		{
			
			ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			crawler=(CrawlerService) context.getBean("crawlerService");
		}
		
		if (crawler.getState()== State.RUNNABLE || crawler.getState()== State.BLOCKED || crawler.getState()== State.TIMED_WAITING || 
				crawler.getState()== State.WAITING)
		{
			crawler.resume();
		}
		
		
		else
		{
		if (crawler.getState()== State.TERMINATED )
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			crawler=(CrawlerService) context.getBean("crawlerService");
			crawler.start();
		}
		else
		{
			try {
				crawler.start();
				modelMap.addAttribute("state", "Đang tiến hành");
				System.out.println("State4:" + crawler.getState());
			} catch (Exception e) {
				System.out.println("State6:" + crawler.getState());
			}
		}
		}
	
		return "admin/crawler";
	}
	
	

	@SuppressWarnings("deprecation")
	@GetMapping(path = "/changestate")
	@ResponseBody
	public CrawlerResponse.State ChangeState(@RequestParam String action) throws IOException, InterruptedException {
		System.out.println("State change:" + crawler.getState() );
		if ((crawler.getState()== State.TERMINATED ) && action.equals("play"))
				{
			ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			crawler=(CrawlerService) context.getBean("crawlerService");
			crawler.start();
			return com.TP.Respone.CrawlerResponse.State.PLAY;
				}
		if (action.equals("stop"))
		{
			crawler.stop();
				return com.TP.Respone.CrawlerResponse.State.STOP;
		}
		if (action.equals("refresh"))
			{
			crawler.stop();
			ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			crawler=(CrawlerService) context.getBean("crawlerService");
			crawler.start();
					return com.TP.Respone.CrawlerResponse.State.REFRESH;
			}
		if (action.equals("pause")) {
			System.out.println("State:" + crawler.getState());
			System.out.println("Waiting for Thread to ...");
				crawler.suspend();
			return com.TP.Respone.CrawlerResponse.State.PAUSE;
			
		} 
		else 
		{
			System.out.println("State:" + crawler.getState());
			System.out.println("Resume ...");
				crawler.resume();
				return com.TP.Respone.CrawlerResponse.State.PLAY;
		}
		
		
		

	}

}
