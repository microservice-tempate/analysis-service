package vn.academy.analysisservice.dto.analysis;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnalysisRequest {
    Long id;
    String message;
    Date createdDate;
}
