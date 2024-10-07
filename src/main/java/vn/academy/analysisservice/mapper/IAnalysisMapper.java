package vn.academy.analysisservice.mapper;

import org.mapstruct.Mapper;
import vn.academy.analysisservice.dto.analysis.AnalysisRequest;
import vn.academy.analysisservice.dto.analysis.AnalysisResponse;
import vn.academy.analysisservice.entity.Analysis;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAnalysisMapper {
    AnalysisResponse toAnalysisResponse(Analysis analysis);

    List<AnalysisResponse> toAnalysisResponses(List<Analysis> analyses);

    Analysis toAnalysisFromAnalysisRequest(AnalysisRequest analysisRequest);
}
