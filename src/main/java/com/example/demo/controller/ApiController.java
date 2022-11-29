package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.ApiService;
import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.Login;
import com.example.demo.vo.Login2;
import com.example.demo.vo.Movie;


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
	
	@Autowired
	EmpMapper empMapper;
	
	
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
	
	/* C(Create)R(Read)U(Update)D(Delete)
	 * Get : 데이터 조회 == select
	 * Post: 데이터 생성 == insert
	 * Patch : 데이터 업데이트 == update
	 * Delete : 데이터 삭제 == delete
	 */
	@PostMapping("/api/v1/join2")
	public boolean callJoin(@RequestBody Login2 login2, HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		System.out.println("요청받은 IP : " + ip);
		
		System.out.println("HTML에서 서버로 받아온 데이터입니다.");
		System.out.println("회사 이름 : " + login2.getCompanyName());
		System.out.println("사용자 이름 : " +login2.getUserName());
		System.out.println("연락처 : "+login2.getPhone());
		
		return true;
	}
	
	@GetMapping("/api/v1/emp")
	public List<EmpVO> callEmp(){
		return empMapper.selectEmp();
	}
	
	@GetMapping("/api/v1/dept")
	public List<DeptVO> callDept(){
		return empMapper.selectDept();
	}
	
	
	
	
}
