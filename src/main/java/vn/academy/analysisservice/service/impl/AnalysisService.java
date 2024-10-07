package vn.academy.analysisservice.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.academy.analysisservice.entity.Analysis;
import vn.academy.analysisservice.repository.IAnalysisRepository;
import vn.academy.analysisservice.service.IAnalysisService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnalysisService implements IAnalysisService {
    IAnalysisRepository analysisRepository;

    @Override
    public Analysis save(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    @Override
    public void delete(Long id) {
        analysisRepository.deleteById(id);
    }

    @Override
    public List<Analysis> getAll() {
        return analysisRepository.findAll();
    }

    @Override
    public Optional<Analysis> findById(Long id) {
        return analysisRepository.findById(id);
    }
}
