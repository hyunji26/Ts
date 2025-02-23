tasteSom
Dongduk Women's University 학생들을 위한 맛집 검색 및 추천 시스템

👨‍🏫 프로젝트 소개
tasteSom은 동덕여대 주변 식당 정보를 제공하고 자주 검색된 메뉴를 추천해주는 웹 애플리케이션입니다. 학생들은 메뉴 검색, 리뷰 작성 및 별점 평가를 통해 식당 정보를 제공받을 수 있습니다. 식당 주인은 자신의 메뉴와 식당 정보를 등록 및 관리할 수 있습니다.

⏲️ 개발 기간
2023.03.01 ~ 2023.05.30

🧑‍🤝‍🧑 개발자 소개
임현지 : DB 설계, 회원 가입, 메뉴 검색, 추천 기능 개발
조유빈 : UI 설계, 리뷰 작성/조회 기능 개발
이진희 : 식당 및 메뉴 등록/수정 기능 개발
💻 개발환경
Version : Java 17
IDE : IntelliJ
Framework : Spring Boot 2.7.11
Build Tool : Gradle
⚙️ 기술 스택
Server : AWS EC2
Database : MySQL, JPA
Frontend : JSP, HTML, CSS
Backend : Spring Boot
Tools : Notion, Discord, Slack
📌 주요 기능
메뉴 검색: 학생 사용자는 원하는 메뉴를 검색하여 해당 메뉴를 제공하는 식당 정보를 확인할 수 있습니다.
메뉴 추천: 자주 검색된 메뉴를 바탕으로 메뉴 추천 기능을 제공합니다.
리뷰 작성 및 별점 평가: 학생 사용자는 식당에 대한 리뷰를 작성하고 별점을 남길 수 있으며, 이 정보는 다른 사용자에게 공유됩니다.
식당 등록 및 메뉴 관리: 식당 주인은 자신의 식당 정보와 메뉴를 등록, 수정, 삭제할 수 있습니다.
📝 설치 및 사용 방법
프로젝트를 클론합니다:
bash
복사
편집
git clone https://github.com/your-repo/tasteSom.git
필요한 라이브러리 및 종속성을 설치합니다.
데이터베이스 설정 후 서버를 시작합니다:
bash
복사
편집
./gradlew bootRun
브라우저에서 localhost:8080에 접속하여 서비스를 이용할 수 있습니다.
