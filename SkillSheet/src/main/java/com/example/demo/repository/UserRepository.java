package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUser;

/*
 * ログインユーザーRepository
 */
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

}
