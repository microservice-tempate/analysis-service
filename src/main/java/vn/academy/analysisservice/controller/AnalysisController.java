package vn.academy.analysisservice.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.academy.analysisservice.dto.ApiResponse;
import vn.academy.analysisservice.dto.analysis.AnalysisRequest;
import vn.academy.analysisservice.dto.analysis.AnalysisResponse;
import vn.academy.analysisservice.entity.Analysis;
import vn.academy.analysisservice.exception.ApiException;
import vn.academy.analysisservice.exception.ErrorCode;
import vn.academy.analysisservice.mapper.IAnalysisMapper;
import vn.academy.analysisservice.service.IAnalysisService;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/analysis")
public class AnalysisController {
    IAnalysisService analysisService;
    IAnalysisMapper analysisMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // get all
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ApiResponse.builder()
                .data(analysisMapper.toAnalysisResponses(analysisService.getAll()))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id") Long id) {
        return analysisService.findById(id).map(a -> ResponseEntity.ok(ApiResponse.builder()
                        .data(analysisMapper.toAnalysisResponse(a))
                        .build()))
                .orElseThrow(() -> new ApiException(ErrorCode.ANALYSIS_NOT_EXIST));
    }

    // add new
    @PostMapping
    public AnalysisResponse create(@RequestBody AnalysisRequest analysisRequest) {
        logger.info("AnalysisController: Add Analysis");

        Analysis analysis = analysisService.save(analysisMapper.toAnalysisFromAnalysisRequest(analysisRequest));
        return analysisMapper.toAnalysisResponse(analysis);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        analysisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody AnalysisRequest analysisRequest) {
        Analysis analysis = analysisMapper.toAnalysisFromAnalysisRequest(analysisRequest);
        analysis.setId(id);

        analysisService.save(analysis);
    }
}
