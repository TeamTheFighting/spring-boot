package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVO;

/*
 * 추상클래스와 인터페이스 차이점
 * 인터페이스 : 메소드 정의
 * 추상클래스 : 정의, 구현 가능
 */
@Mapper
public interface EmpMapper {

	
	/**
	 * @Since : 2022. 11. 28.
	 * @Author : mr.Hyun
	 * @Return : List<EmpVO>
	 * @Comment : EMP 테이블 전체 조회
	 */
	List<EmpVO> selectEmp(); //메소드 정의
	
	/**
	 * @Since : 2022. 11. 29.
	 * @Author : mr.Hyun
	 * @Return : List<DeptVO>
	 * @Comment : Dept 테이블 전체 조회
	 */
	List<DeptVO> selectDept();
	
	
	
	
	
	
	
 	
}
