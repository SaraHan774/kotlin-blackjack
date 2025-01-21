# kotlin-blackjack

### 2단계 기능 요구사항 

- 블랙잭 게임이란 :  블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다.
- 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

### 2단계 프로그래밍 요구사항 

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 모든 엔티티를 작게 유지한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.

### 2단계 구현 기능 목록 

- 기능 요구사항 바탕으로 테스트코드 작성
- 테스트코드 컴파일 되도록 코드 수정
- 게임의 주체를 나타내는 Player 객체 정의 
- 블랙잭 카드를 표현할 수 있는 객체 정의


- 3단계 목록이 날라갔네 .. 

### 4단계 구현 기능 목록 

- [x] 플레이어는 게임을 시작할 때 베팅 금액을 정해야 한다. 
- 베팅 관련 규칙 추가 
  - [x] 카드를 추가로 뽑아 21을 초과할 경우 베팅 금액을 모두 잃게 된다.
  - [x] 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다. 
  - [x] 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
  - [x] 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다.

### 4단계 프로그래밍 요구사항
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 딜러와 플레이어에서 발생하는 중복 코드를 제거해야 한다.

---

### 기능 요구 사항 
- Hit 
- Stay 
- BlackJack 
- Bust 

### 기능 목록
- Ready -> 카드 2장 -> Hit
- Ready -> 카드 2장 -> BlackJack 
- Hit -> 카드 1장 -> Hit 
- Hit -> 카드 1장 -> Bust 
- Hit -> Stay 
- Bust -> x 
- Stay -> x 
- BlackJack -> x 
