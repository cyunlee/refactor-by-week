# 프리코스 1주차 미션 - 문자열 덧셈 계산기

## 미션 목표 (Objectives)

> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

## 시작하기 (Getting Started)

<img alt='시작하기' src="docs/git.png" style="width: 600px"/>

1. 저장소를 포크하고 클론한다.
2. 클론한 폴더로 이동 후 브랜치를 생성한다.
3. IDE에서 폴더를 열고 코드를 작성한다.

## 사용 예시 (Usage)

![1주차시연영상](https://github.com/user-attachments/assets/640be094-34d9-4d2f-ab76-aef3340cecdf)

## 기능 목록 (Features)

- [x] 계산기의 입출력 틀 구현하기 **InputManager, OutputManager**
    - [x] 사용자로부터 문자열 입력받기
    - [x] 결과 출력하기
- [x] 구분자를 기준으로 문자열에서 숫자를 추출하기 **StringCalculator**
    - [x] 쉼표(,) 또는 콜론(:) 구분자가 문자열에 포함되는 경우 #calculateSum
    - [x] 커스텀 구분자가 문자열에 포함되는 경우 #handleCustomInput, #calculateSum
        - [x] 커스텀 구분자와 기본 구분자가 동시에 문자열에 포함되는 경우
    - [x] 구분자가 없는 경우 #processCalculate
        - [x] 빈 문자열로 주어진 경우
        - [x] 단일 숫자의 문자열로 주어진 경우
- [x] 예외 처리하기 - IllegalArgumentException 발생 후 애플리케이션 종료 **Validator**
    - [x] 입력 문자열이 양수 조건에 어긋나는 경우 #checkInputValid
        - [x] 0을 포함하는 문자열을 입력한 경우
        - [x] 음수 혹은 숫자가 아닌 것을 포함하는 문자열을 입력한 경우
    - [x] 커스텀 구분자 입력 양식이 틀린 경우 #checkCustomStyle
        - [x] 커스텀 구분자 필수 요소는 포함되어 있지만 위치가 틀린 경우
        - [x] 커스텀 구분자 필수 요소가 일부만 포함된 경우
        - [x] 커스텀 구분자 필수 요소 없이 기본 구분자 이외의 구분자를 사용한 경우
    - [x] 커스텀 구분자가 빈 문자열인 경우 #checkCustomEmpty

## 기타 요구사항 목록 (Requirements)

- [x] JDK 21 버전임을 확인하기
- [x] 자바 코드 컨벤션을 지키면서 코드 구현하기
- [x] README.md에 정리한 기능 목록을 기반으로 커밋하기
- [x] AngularJS Git 커밋 메시지 컨벤션을 지키면서 커밋 메시지 작성하기
- [x] 제공된 Console API를 사용하여 구현하기

## 추가 학습내용 및 과제수행 시 중점 사항 (Learning & Key Takeaways)

- [자바 개념 및 문법 정리하기(자바의 정석 base, ~ing)](https://github.com/cyunlee/java-essentials-notes)
- 과제수행 시 중점 사항 (신경 쓴 부분)
    - main 함수에서 모든 것을 구현하지 않고, 클래스로 분리하기
        - StringCalculator, Validator, InputManager, OutputManager, Constant로 분리함
        - Application에서 계산기를 실행함
    - 하나의 클래스가 하나의 책임을 갖도록 구현하기
        - StringCalculator(계산)
        - Validator(에러 처리)
        - InputManager(사용자 입력)
        - OutputManager(화면 출력)
        - Constant(상수 및 메시지 보관)
    - 하나의 메서드가 하나의 역할을 하도록 구현하기
        - 변수와 메서드의 이름을 알아보기 쉽도록 작성하기
        - 중복된 코드는 메서드로 설정해서 코드를 간소화하기
    - 하드 코딩 된 문자열 or 숫자를 상수로 설정하기
    - 절차 지향으로 작성하지 않고 객체 지향으로 작성하기
        - 클래스들을 각각 인스턴스화하여 값과 메서드에 접근함
        - StringCalculator 내부의 값과 기능을 외부로부터 보호하기 위해 캡슐화함
        - StringCalculator 내부에서 생성자를 이용해 Validator 클래스의 의존성을 주입함

### 입출력 요구 사항

#### ✍️ 입력

- 구분자와 양수로 구성된 문자열

#### 📃 출력

- 덧셈 결과

```shell
결과 : 6
```

#### 실행 결과 예시

```shell
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

### 과제 진행 요구 사항

- 미션은 [문자열 덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 README.md에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를 작성한다.
- 자세한 과제 진행
  방법은 [프리코스 진행 가이드 문서](https://github.com/woowacourse/woowacourse-docs/tree/main/precourse#%EC%A0%9C%EC%B6%9C-%EA%B0%80%EC%9D%B4%EB%93%9C)
  를 참고한다.

### 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그래밍 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
    - camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
        - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 프로그래밍 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)을 지키면서 프로그래밍한다.

## 테스트 (Testing)

- 터미널에서 java -version을 실행하여 Java 버전이 21인지 확인한다.

<img alt="자바 버전" src="docs/version.png" style="width: 600px" />

- gradlew.bat clean test 또는 ./gradlew.bat clean test 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

<img alt="빌드 테스트" src="docs/test.png" style="width: 850px" />

- 테스트 코드 실행 결과

<img alt="테스트 코드 결과" src="docs/testresult.png" style="width:270px" />








