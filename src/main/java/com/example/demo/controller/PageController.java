package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Contrller는 페이지 주소를 작성할 때 사용하는 어노테이션
@Controller
public class PageController {

	@GetMapping("/")
	public String callIndexPage(HttpServletRequest request) {
		
		String ip = request.getRemoteAddr(); //IP 추적
		System.out.println("요청받은 IP : " + ip);
		
		return "index";
	}
	
	//사용자(클라이언트)가 /home 주소를 입력하면
	// home이름을 가진 html을 return 한다는 걸 의미.
	@GetMapping("/home")
	public String callHomePage(HttpServletRequest request) {

		String ip = request.getRemoteAddr(); //IP 추적
		System.out.println("요청받은 IP : " + ip);
		
		return "home";
	}
	
	@GetMapping("/movie")
	public String callMoviePage() {
		return "movie";
	}
	
	@GetMapping("/login")
	public String callLoginPage() {
		return "login";
	}
	
	@GetMapping("/login2")
	public String callLoginPage2() {
		return "login2";
	}
	
	@GetMapping("/login3")
	public String callLoginPage3() {
		return "login3";
	}
	
	@GetMapping("/emp")
	public String callEmpPage() {
		return "emp";
	}
	
	@GetMapping("/users")
	public String callUsersPage() {
		return "users";
	}
	
	
}