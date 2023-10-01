# 프리온보딩 백엔드 인턴십 선발 과제
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=oracle&logoColor=white" /> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat&logo=springboot&logoColor=white" />

## 요구 사항 분석
* 서비스 개요
  * 본 서비스는 기업의 채용을 위한 웹 서비스 입니다.
  * 회사는 채용공고를 생성하고, 이에 사용자는 지원합니다.

* 구현해야할 기능
  * 채용공고 등록, 수정, 삭제, 전체 목록, 상세 내용 확인, 검색
  * 사용자의 채용공고 지원

* 고려해야할 부분
  * 채용공고, 회사, 사용자, 지원내역 총 4가지의 DB 테이블 필요함.
  * 채용공고는 회사에서 올리는 것으로 채용공고 테이블과 회사 테이블은 연관이 있음.
  * 지원내역은 사용자가 채용공고에 지원하는 것으로 지원내역 테이블은 사용자 및 채용공고 테이블과 연관이 있음.
  * 검색기능은 회사명, 채용포지션, 사용기술에 포함된 단어와 검색 키워드 일치하는 데이터를 출력함.

## 기본 구성
* DB 구성
  * 요구사항에 주어진 데이터 예시를 보고 각 테이블의 필요 컬럼을 생각하여 테이블을 구성하였고, 관련 있는 테이블끼리는 spring boot에서 모델 작성 시 연관관계를 설정해 주었습니다.
<br /> ![DB_ERD](https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/2fca39a0-a0b4-4af0-ad73-99bd8c75ba52)

* 패키지 구성
  * controller, model, repository, service로 나누어 구성하였습니다.
  <br /> ![package_info](https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/6ac97694-2af0-4f86-8d49-f78fc2667a72)
  
  * **Entity**는 채용공고 -> JopPost, 회사 -> Company, 사용자 -> Member, 지원내역 -> Applies로 구성하였습니다. <br /> <img src="https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/019c3cc2-9f6f-4144-82d8-b10ce0e3f6e7" width="500" /> <img src="https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/ad101ba5-e83b-4f6d-94bd-744220956f70" width="500" />

    - JopPost와 Applies는 BaseTimeEntity의 상속을 받아 DB에 저장될 때 생성시간 createdAt, 수정시간 updatedAt을 같이 기록되게 했습니다.
    - JopPost는 Comapany와 N:1 관계, Applies는 Member와 N:1, JopPost와 N:1 관계를 설정해 주어서 데이터 생성 및 조회 할 경우 연관된 데이터를 쉽게 사용할 수 있도록 했습니다.

  <hr />
  
  * **DTO**는 Request 3개 (AppliesReq, JopPostAddReq, JopPostUpdateReq), Response 2개 (JopPostDetailRes, JopPostListRes)를 만들었다.
    
    - Request DTO에서는 받은 json을 객체변환하고 변환된 객체를 사용하기 위해 @Getter, @AllArgsConstructor, @NoArgsConstructor의 annotation을 사용했습니다.
    <br /> ![request_dto](https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/d5b4b5de-2e8c-485d-be88-47b1c47caf7a)

    - Response DTO에서는 데이터 사용을 위해 @Getter annotation만 사용하고, 필요한 생성자만 따로 작성해 주었습니다.
    <br /> <img src="https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/70ffdb97-7e3e-4143-9872-7f29335f49fc" width="500" />

  <hr />
  
  * **Repository**는 객체 별로 생성 후, JopPostRepository에만 검색 기능을 위한 쿼리 메소드 한 개와 회사의 다른 채용 목록 표시를 위한 쿼리 메소리 한 개를 추가하였습니다.
  <br /> ![jopPostRepository](https://github.com/chickencoc/wanted-pre-onboarding-backend/assets/74812739/ab77c3b2-116b-4cfc-850d-1946c072f007)

 
# 기능 구현
* 채용공고 등록 Create


   











