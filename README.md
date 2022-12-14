# unkind-modeling
불친절한 모델링

## step 1

1. 현재 코드의 문제점을 파악해주세요.
2. 코드를 보고 모델링을 구현해주세요.- 객체들의 상태와 행위를 정의해주세요.
3. 객체 다이어그램을 작성해주세요.
4. 사용자 시나리오를 정의해주세요.

(Optional) 할인은 어떻게 구현할까요?

> 사용자 시나리오 예시) 사용자가 보고 있는 책을 주문할 수 있습니다.

## step 2

1. 모델링과 사용자 시나리오를 기반으로 e2e 테스트를 먼저 구현해주세요!
2. 모델링을 기반으로 API 문서를 작성해주세요!

## step 3

1. 패키지를 리팩토링 합니다.
2. 코드를 리팩토링합니다.
3. 롬복을 이용해서 가독성을 높입니다.
4. 다양한 방식으로 빈을 등록하고 그 중 하나를 선택해서 빈으로 등록합니다.

## step 4

1. 테스트 방향을 정하고 테스트를 구현합니다.
   1. 협력 객체가 없는 상황부터 테스트를 진행합니다.
   2. 구현한 순서대로 테스트를 진행합니다.
2. 테스트를 구현할 때, 테스트 더블을 이용해서 구현합니다. 테스트는 총 세 가지 방법으로 구현해보고 그 중 한 방법을 선택해서 구현합니다.
   1. Fake
   2. Stub
   3. Mock


## 할인 요구사항과 할인 쿠폰 종류

### 요구사항

1. 할인은 최대 책 가격의 40퍼센트 까지만 적용됩니다. 40퍼센트 이상을 넘기면 사용할 수 없습니다.
2. 할인은 가격에 비례한 방법이 있고, 고정된 금액을 할인하는 방법이 있습니다. 두 개의 할인은 동시에 사용할 수 있지만, 같은 종류의 할인은 동시에 사용할 수 없습니다.
3. 동시 할인이 있는 경우 가장 싼 가격으로 결제되도록 합니다.
4. 쿠폰 종류는 다음과 같습니다.
   
- ONE_THOUSAND_FIXED,
  - 1000원을 할인합니다.
- TWO_THOUSAND_FIXED,
  - 2000원을 할인합니다.
- FIVE_PERCENT,
  - 5% 할인합니다.
- TEN_PERCENT
  - 10% 할인합니다.
