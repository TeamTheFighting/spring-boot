package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.UsersVO;

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
	
	
	/**
	 * @Since : 2022. 12. 1.
	 * @Author : mr.Hyun
	 * @Return : int
	 * @Comment : 사원 추가
	 */
	int insertEmp(EmpVO vo);
	
	
	/**
	 * @Since : 2022. 12. 1.
	 * @Author : mr.Hyun
	 * @Return : int
	 * @Comment : 사원  삭제
	 */
	int deleteEmp(int empno);
	
	
	/**
	 * @Since : 2022. 12. 1.
	 * @Author : mr.Hyun
	 * @Return : int
	 * @Comment : 사원 정보 수정
	 */
	int updateEmp(EmpVO vo);
	
	
	/**
	 * @Since : 2022. 12. 2.
	 * @Author : mr.Hyun
	 * @Return : int
	 * @Comment : 회원 가입
	 */
	int insertUsers(UsersVO vo);
	
	
 	/**
 	 * @Since : 2022. 12. 2.
 	 * @Author : mr.Hyun
 	 * @Return : int
 	 * @Comment : 회원인지 아닌지 체크
 	 */
 	int selectUsersFindById(UsersVO vo);
}
