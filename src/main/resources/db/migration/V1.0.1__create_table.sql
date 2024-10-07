CREATE TABLE analysis
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    message      VARCHAR(255)          NULL,
    created_date datetime              NULL,
    CONSTRAINT pk_analysis PRIMARY KEY (id)
);