use demo_user_service;


INSERT INTO user(id, username, password)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'user', '$2a$12$nXbKphoMKGPdEmJywVR7/O2n1I/4eVoNGt.UXZMYcI2Y0DHmbxkTy');

INSERT INTO user(id, username, password)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'admin', '$2a$12$RIlXFNm9pBuE8HHaXrqHZ.EAPTHaKn3y8IRBUegEnv/0jZ..yhvwm');