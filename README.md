# 주차별 피드백 기반 학습한 내용

## 📃week1

### Git
> 명령어들을 숙지하고, git의 형상 관리가 필요한 코드인 지를 고려한다.

#### 개념
- **커밋** : 커밋은 Git 저장소에 디렉토리에 있는 모든 파일에 대한 스냅샷을 기록하는 것이다. 각 커밋은 저장소의 이전 버전과 다음 버전의 변경내역(delta)를 저장한다.
그렇기 때문에 대부분의 커밋은 그 커밋 위의 부모 커밋을 가리킨다. 
- **브랜치** : 소프트웨어를 개발할 때 개발자들이 **동일한 소스코드를 함께 공유**하고자 할 때 사용하며, 동일한 소스코드를 기반으로 **서로 다른 작업을 할 떄** 활용된다. 
간단히 말하면, 하나의 커밋과 그 커밋의 부모 커밋들을 포함하는 작업 내역을 의미한다. 
동시에 다양한 작업을 할 수 있게 만들어주며, 각자 독립적인 작업 영역을 생성하고 원래 버전과 비교해서 새로운 버전을 만들 수 있다. 
브랜치는 특정 커밋에 대한 참조(reference)에 불과하기 때문에 브랜치를 많이 생성해도 메모리나 디스크 공간에 부담이 되지 않는다.
- **HEAD** : 현재 작업중인 커밋의 위치, 작업트리의 가장 최신의 커밋을 가리킨다. 작업트리에 변화를 주는 git 명령어들은 HEAD를 변경하는 것으로부터 시작한다. 일반적으로 헤드는 브랜치를 가리킨다.
- **체리-픽** : 좋은 것만 골라서 사용한다는 뜻으로, 커밋을 골라서 가져올 수 있다. 범위를 지정(가장 처음 해시값...맨 끝 해시값)해서 커밋들을 가져올 수도 있다. 
- **상대 참조** : 브랜치나 커밋을 현재 HEAD를 기준으로 참조한다. 상대 참조는 브랜치를 옮길 때 가장 일반적으로 많이 사용한다. ex) git branch -f main HEAD~3
  - `^`(캐럿) : 한번에 한 커밋 위(커밋의 부모)로 움직인다. ex) git checkout main^, git checkout HEAD^^ 
  - `~<num>` : 한번에 여러 커밋 위로 올라간다. ex) 

#### 명령어
|   command   |                                                            설명                                                             |           예시            |
|:-----------:|:-------------------------------------------------------------------------------------------------------------------------:|:-----------------------:|
|   commit    |                                                        변경사항을 저장한다                                                         |       git commit        |
|   branch    |                                                  브랜치를 생성한다 (옮길 때도 사용한다)                                                   |    git branch bugFix    |
|  checkout   |                                                    브랜치를 이동한다 (switch)                                                     |   git checkout bugFix   |
| cherry-pick |                                                        특정 커밋을 복사한다                                                        | git cherry-pick bugFix^ |
|    reset    | 브랜치를 예전의 커밋으로 옮긴다 (로컬)<br/> --hard : 변경 사항을 삭제 <br/> --mixed : 변경 사항을 unstaged 상태로 유지 <br/> --soft : 변경 사항을 staged 상태로 유지 |    git reset HEAD~1     |
|   revert    |                                되돌리고 다른 사람과 공유한다 (리모트) <br/> reset, amend와 달리 새로운 커밋을 생성한다                                 |     git revert HEAD     |
|   rebase    |                                                한 브랜치의 커밋들을 다른 브랜치의 끝에 정렬한다                                                |     git rebase main     |
|    merge    |                                                     두 개의 브랜치를 하나로 합친다                                                     |    git merge bugFix     |

- 브랜치 생성 : `git branch '브랜치 이름'` ex) git branch step1
- 브랜치 이동 : `git switch '이동할 브랜치 이름'` ex) git switch step1
- 커밋 생성 : `git commit`
- 브랜치 병합 : `git swtich '이동할 브랜치 이름'` + `git merge '합칠 브랜치 이름'`
- HEAD 위치를 이전으로 변경 : `git switch HEAD^` or `git swtich HEAD~n`
- 브랜치 위치를 다른 브랜치 기준 커밋으로 변경 : `git branch -f '이동할 브랜치 이름' '기준 브랜치 이름~n'` ex) git branch -f step2 step1~2
- 삭제된 커밋 복구하기 : `git reset --hard '커밋의 해시값'` 
- 특정 커밋으로 이동하기 : `git cherry-pick '해시값'`

#### 작업하면서 자주 사용한 기능
- git의 변경 이력에 대한 모든 로그 확인하기 : `git reflog`
- git commit 취소하기 : `git reset HEAD~n`
- git push 취소하기 : commit 취소 명령어를 입력한 후, add -> commit -> `git push -f origin '브랜치 이름'`
  - 여러 명이 관리하는 원격 저장소의 경우 -f를 사용하면 문제가 발생 할 수있다.
- git commit 메시지 변경 / 변경사항 추가하기 : `git commit --amend`
  - amend를 수행한 커밋은 기존 커밋과 완전히 다른 별개의 커밋이 된다. (기존 커밋을 덮어쓴다.)
  - 따라서 이미 push를 수행한 커밋과 다른 작업자가 작성한 내용에 대해서는 amend 옵션을 사용하면 안 된다.
- 커밋의 해시값을 입력할 때는 구별할 수만 있도록 앞글자 몇자를 입력하면 된다. (전부 할 필요x)

#### .gitignore
- .gitignore 파일은 프로젝트 최상위 위치에 존재해야 한다. 
- 작성 패턴 
  - '#', 빈 라인 : 는 주석을 의미하며, 빈 라인은 아무런 영향을 주지 않는다.
  - *.a : 확장자가 .a인 모든 파일을 무시한다.
  - folder_name/ : 해당 폴더의 모든 파일을 무시한다.
  - folter_name/*.a : 해당 폴더에서 확장자가 .ad인 모든 파일을 무시한다.
- [.gitignore 파일을 생성 해주는 사이트](www.gitignore.io)

### 커밋 메시지
> 커밋에서 수행한 작업을 함축하여 의미 있게 작성하고, 이슈/풀 리퀘스트 번호를 포함하지 않는다. 

#### 형식 
```text
<type>(<scope>): <short summary>
```

#### type
- feat : 새로운 기능 추가 
- fix : 버그 수정
- docs : 문서 관련
- style : 스타일 변경
- refactor : 코드 리팩토링
- test : 테스트 관련 코드
- build : 빌드 관련 파일 수정
- ci : CI 설정 파일 수정
- perf : 성능 개선
- chore : 그 외 자잘한 수정

### 디버거
> System.out.println() 대신 디버거를 사용하자.

#### 활용
- **디버그 모드**란? : break point를 잡으면 프로그램을 멈추고 상태를 살펴서 코드를 점검하는 기능을 제공한다.
  - 실행 방법(shift + F9) : 살펴보고 싶은 코드에 break point를 잡고, 디버그 모드를 실행하면 된다.
  - 화면
    - 왼쪽 칸 : break point가 잡히기까지의 스택을 나타낸다. 메서드가 실행된 자리까지 어떤 스택이 실행되었는지?
    - variables 칸: 지역 스코프에 담겨져 있는 변수들이 나타난다.
    - resume 버튼 : 다음 break point로 넘어간다.
    - step over 버튼 : 다음 줄로 넘어간다.
    - step into 버튼 : 브레이크가 걸린 라인 내부의 로직(메서드)으로 들어간다.
    - step out 버튼 : 스택을 빠져나온다.
    - drop frame 버튼 : 실행 되지 않고 step out 된다.
    - run to cursor 버튼 : break point를 찍지 않고도 바로 넘어갈수 있는 기능이다.
  - break point에 우클릭을 하면 해당 break point의 모든 메서드를 사용할 수 있다. 
    - condition에 특정한 값을 넣으면 오류를 발견할 수 있다. 
  - evaluate : 디버깅 중에 자바 코드를 실행할 수 있다. (단, 코드에 실제로 적용되고 실행된다.)
  - 뒤로가기와 취소는 디버깅에 존재하지 않는다. (유사한 기능은 Reset Frame) 
  
### 코드 가이드라인
- 변수, 함수, 클래스의 이름을 지을 때 **역할의 의도**를 담을 수 있게 짓는다. (연속된 숫자, 불용어 사용X)
  - 만약 의도를 담을 수 있다면 길어져도 괜찮고, 이름을 **축약하지 않는다.**
  - 클래스와 메서드의 이름은 1~2 단어 길이로 유지한다.
- 공백도 코딩 컨벤션에 포함된다.
  - 공백을 의미있게 사용해야 한다. 문맥을 분리하는 용도로 공백 라인을 사용한다.
  - 들여쓰기를 할 때는 스페이스와 탭 둘 중에 하나만 사용한다.
- 주석은 메서드의 이름으로 의도를 드러내기 힘들 때만 작성한다.
- 자바의 **내장 API**를 최대한 활용한다. 
  - 배열보다는 **컬렉션**을 활용하면 API를 이용해 코드를 효율적으로 구현할 수 있다.
  
### 참고 자료
- [링크1 | git 게임](https://learngitbranching.js.org/?locale=ko)
- [링크2 | git.ignore](https://inpa.tistory.com/entry/GIT-%E2%9A%A1%EF%B8%8F-gitignore-%EC%9E%90%EB%8F%99-%EC%83%9D%EC%84%B1)
- [링크3 | AngularJS 커밋메시지 컨벤션](https://velog.io/@outstandingboy/Git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%8B%9C%EC%A7%80-%EA%B7%9C%EC%95%BD-%EC%A0%95%EB%A6%AC-the-AngularJS-commit-conventions)
- [링크4 | Intellij 디버거 활용법](https://www.youtube.com/watch?v=gkutTlwi70s)
- [링크5 | Intellij 디버거 활용법(요약)](https://www.youtube.com/watch?v=JSVvhwwOvAY)