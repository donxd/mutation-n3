package com.teamknowlogy.testapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamknowlogy.testapi.dto.SecuenceResult;

@Repository
public interface SecuenceResultRepository extends JpaRepository<SecuenceResult, Integer> {
	public List<SecuenceResult> findByDna (String dna);
	public List<SecuenceResult> findByResult (boolean result);
}