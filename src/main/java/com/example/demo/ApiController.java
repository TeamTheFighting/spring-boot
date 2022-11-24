package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
 * RestController와 Controller 차이점
 * 
 * Controller는 페이지(html) 이동
 * RestController는 데이터(JSON) 전송
 * 
 * Controller는 사용자 요청(URL 요청)을 처리하는 class
 * Controller에서 로직을 구현 X
 */

//Rest : 자원 (== 데이터)
@RestController
public class ApiController {
	
	//@Autowired : Spring에서 객체를 관리함 (IoC : Inversion of Control 제어 역전) 
	@Autowired
	ApiService apiService; //클래스를 전역변수로
	
	/*
	 * 클래스 이름 : 앞에 대문자로 시작 ex) Apple (o) apple (x)
	 * 변수 명 : 상수를 제외한 변수 이름은 소문자 : String name (o) String Name (x)
	 * 상수 : final double PI = 3.14 (o), final double pi = 3.14 (x), 
	 * 함수이름 : 명사 (x) 동사 (o) ex) function makeData(o) function data(x) 
	 */
	@GetMapping("/api/v1/sample")
	public List<String> callData(){
		
		List<String> list = new ArrayList<String>();
		list.add("삼겹살");
		list.add("오리고기");
		list.add("목살");
		
		return list;
	}
	
	//Get: 조회
	//Mapping : URL 연결
	//v1: 버전을 의미 (version 1)
	@GetMapping("/api/v1/movie")
	public Movie callMovie() {
		
		Movie movie = new Movie();
		movie.setTitle("Just Friends");
		movie.setYear("2005");
		movie.setRuntime("96 min");
		movie.setGenre("Comedy, Romance");
		//movie라는 객체를 전달함
		return movie;
	}
	
	//URL 이름은 중복될 수 없다.
	@GetMapping("/api/v1/movies")
	public List<Movie> callMovies(){
		
		return apiService.makeMovies();
	}
	
	//URL을 이용한 데이터 받는 방법
	//Path 길(주소 or 경로)로 데이터 받기
	//Path(경로) + Variable (값)
	@GetMapping("/api/v1/sports/qatar2022/article/{articleNumber}")
	public int callAtricle(@PathVariable int articleNumber) {
		return articleNumber;
	}
	
	// 쿼리스트링으로 데이터 받기
	// /api/v1/webtoon/list?titleId=758037&weekday=mon
	//Request(요청) +  Param (파라미터)
	@GetMapping("/api/v1/webtoon/list")
	public Map<String, Object> callWebtoon(@RequestParam int titleId, @RequestParam String weekday){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleId", titleId);
		map.put("weekday", weekday);
		
		return map;
	}
	
	//문제) 위에 웹툰 주소 쿼리스트링 -> path 로 변경
	@GetMapping("/api/v1/webtoon/list/titleId/{titleId}/weekday/{weekday}")
	public Map<String, Object> callWebtoon2(@PathVariable int titleId, @PathVariable String weekday){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleId", titleId);
		map.put("weekday", weekday);
		
		return map;
	}
	
	//Post: 데이터를 받아서 생성할 때
	@PostMapping("/api/v1/join")
	public boolean callJoin(@RequestBody Login login) {
		System.out.println("HTML에서 서버로 받아온 데이터입니다.");
		System.out.println("아이디 : " + login.getUserId());
		System.out.println("이메일 : " +login.getUserEmail());
		System.out.println("비밀번호 : "+login.getUserPassword());
		
		return true;
	}
	
	
	
}
