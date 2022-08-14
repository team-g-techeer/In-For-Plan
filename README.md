# In-For-Plan
# readme

Created: 2022년 8월 11일 오후 8:50
Last Edited Time: 2022년 8월 13일 오후 4:10

# InForPlan

---

> Inforplan은 다양한 국가 및 지역에 살고 있는 사람들과 함께 온라인 회의를 진행하는데 있는 시차 문제를 해결하기 위한 온라인 프로젝트 & 회의 일정 관리 웹 사이트 입니다.
> 

---

## 선정 이유

📍 **회의시간 계산 및 설정의 어려움**

해외에 있는 팀원과 온라인 회의를 진행하는 과정에서 시차 문제로 인해 회의 시간을 수동으로 계산하고 정하는 것에 어려움이 있음

📍 **착각하기 쉬운 회의 시간**

회의시간이 정해져도 자신이 거주하고 있는 곳에서의 시간을 기준으로 애기 하지 않으면 회의 시간을 착각하는 경우가 많음

## 해결 방법

💡 온라인 회의가 필수적인 온라인 프로젝트 팀을 위해 회의 시간 시차 자동조정 기능을 추가한 프로젝트 일정 관리 웹 사이트를 만들고자 함

- 각자의 가능한 시간대를 입력하면 팀원 모두의 가능한 시간대를 자동으로 계산해주는 기능이 필요
- 자신이 거주 중인 나라에 맞게 결과값을 보여줌으로써 혼란 방지
- 프로젝트 별로 일정 및 태스크를 관리할 수 있도록 함

## 회원가입

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled.png)

- Google Oauth 회원가입과 기본 회원가입이 사용가능합니다.

## 로그인 화면

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled%201.png)

## 메인 페이지

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled%202.png)

- 메인페이지에서 달력을 통해 지난 일정 및 남은 일정을 확인할 수 있고, 오늘 예정된 일정 이나 To Do List, Project 를 확인할 수 있습니다.

## 프로젝트 페이지

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled%203.png)

- 칸반 보드를 사용하여 프로젝트내의 Task를 구분할 수 있으며, 회의 일정을 설정 할 수 있습니다.

## 칸반 보드 페이지

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled%204.png)

- 칸반 보드 내에서는 멤버 추가,  파일 업로드 , Label 추가, 댓글작성, check list 추가, member mention 기능을 사용할 수 있습니다.

## 회의 시간 설정 페이지

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled%205.png)

- 회의 시간을 정하기 위해 외국에 있는 member의 시차를 계산할 필요없이 한눈에 공통된 시간을 확인할 수 있습니다.

## System Architecture

![Untitled](readme%20adc054e78fda4a669ef9d2ad0ffa3c1d/Untitled%206.png)

## 실제 구현 서비스

### 백엔드

- 로그인, 회원가입 - Google Oauth 로그인 및 기본 회원가입/로그인 가능
- 프로젝트 일정 관리 기능
    - 프로젝트 생성, 수정, 삭제 기능
    - 칸반보드 생성, 수정, 삭제 기능
    - 태스크 생성, 수정, 삭제 기능
- 온라인 회의 시간 결과값 반환

### 프론트엔드

- 로그인, 회원가입 페이지
- 메인페이지
    - 캘린더 및 일정
    - 참여하고 있는 프로젝트
- 칸반보드 페이지
    - 회의 시간 설정 모달창
    

## 데모 영상

## Tech Stack

| Frontend | Backend | WebServer | Deploy |
| --- | --- | --- | --- |
| React | SpringBoot | Nginx  | Github Action |
|  | PostgreSQL |  | Docker |
|  | Redis |  | AWS EC2 |
|  | Grafana |  |  |
|  | Prometheus |  |  |

## 팀원

| 이름  | 역할 | Github |
| --- | --- | --- |
| 맹수연  |  |  |
| 유희진 |  |  |
| 임성한  |  |  |
| 최세연 |  |  |
