package vn.academy.analysisservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.academy.analysisservice.entity.Analysis;

public interface IAnalysisRepository extends JpaRepository<Analysis, Long> {
}
