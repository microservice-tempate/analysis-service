package vn.academy.analysisservice.service;


import vn.academy.analysisservice.entity.Analysis;

import java.util.List;
import java.util.Optional;

public interface IAnalysisService {
    Analysis save(Analysis analysis);

    void delete(Long id);

    List<Analysis> getAll();

    Optional<Analysis> findById(Long id);
}