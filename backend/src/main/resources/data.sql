-- Company Sample
INSERT INTO company (`name`, `country`, `city`) VALUES ('원티드랩', '한국', '서울');
INSERT INTO company (`name`, `country`, `city`) VALUES ('원티드코리아', '한국', '부산');
INSERT INTO company (`name`, `country`, `city`) VALUES ('네이버', '한국', '성남');
INSERT INTO company (`name`, `country`, `city`) VALUES ('카카오', '한국', '제주');

-- Member Sample
INSERT INTO member (`email`) VALUES ('user001@gmail.com');
INSERT INTO member (`email`) VALUES ('user003@gmail.com');
INSERT INTO member (`email`) VALUES ('user005@gmail.com');

-- JopPost Sample
INSERT INTO jop_post (`position`, `reward`, `tech_stack`, `content`, `created_at`, `updated_at`, `company_no`)
    VALUES ('프론트엔드 개발자', 500000, 'Javascript', '원티드코리아에서 백엔드 주니어 개발자를 채용합니다.', now(), now(), 2);
INSERT INTO jop_post (`position`, `reward`, `tech_stack`, `content`, `created_at`, `updated_at`, `company_no`)
    VALUES ('Django 백엔드 개발자', 1000000, 'Django', '네이버에서 Django 백엔드 개발자를 채용합니다.', now(), now(), 3);
INSERT INTO jop_post (`position`, `reward`, `tech_stack`, `content`, `created_at`, `updated_at`, `company_no`)
    VALUES ('Django 백엔드 개발자', 500000, 'Python', '카카오에서 Django 백엔드 개발자를 채용합니다.', now(), now(), 4);
