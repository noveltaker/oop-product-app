

## 객체 설계 

<img width="745" alt="Screen Shot 2022-05-15 at 3 23 03 PM" src="https://user-images.githubusercontent.com/53357210/168460084-af6a4f90-6115-4d2a-bd0b-010d50bd0e58.png">


### 시스템 관련 

* Data (interface) : 콤마, 큰따움표 별로 데이터가 정의되어 있어서 created 메소드르 통해서 데이터를 만드는 기능 정의 
* DoubleQuotationData, CommaData (class) : 콤마, 큰따움표 별 각각의 클래스 정의 Data interface 에서 정의된 created 메소드를 각각 오버라이드 해서 각각 정의
* Load (intreface) : 데이터를 가지고 오는 기능을 정의 (ex) csv, json, 코드 데이터를 정의 하기 위해서 사용)
* DataLoader (class) : 코드 데이터를 가지고 오는 로더 / load interface 를 상속 
* input (interface) : 시스템에서 input 되는 scaaner 역할을 하는 기능을 정의된 인터페이스 , 제네릭을 써서 Long, String, ... 각각 데이터에 대한 확장성을 가지고 설계 
* StringInput (class) : input<String> 을 상속을 받는 클래스로 String 타입에 대한 스캐너 기능을 정의 

### 비지니스 관련 
* work (interface) : work 메소드 기능을 정의 
* AbstractBaseWork (abstractClass) : 기본적인 work에 대한 관점을 정의를 해주는 추상화 클래스 
* MainBaseWorker (class) : 시스템의 전반적인 Main Work 기능을 정의 (AbstractBaseWork 를 상속을 받앗 사용을 한다)
* QuitWoker (class) : work interface 를 상속을 받으며 quit 에 대한 기능을 정의된 클래스 
* AbstractWoker (abstractClass) : 주로 OrderWoker 의 기능을 담았으나 확장성을 고려해서 AbstracBaseWoker 를 상속을 받아 사용을 한다 , 기능의 대한 정의를 interface 로 함으로써 상속된 interface 를 통해서 다형성을 고려함과 동시에 형변환에 대한 부분 단일 인터페이스로 받을 수 있게 쪼게 였다. 
* Count (interface) : 주문 수 에 대한 기능을 정의 
* Quit (interface) : 종료에 대한 기능을 정의 
* Printer (interface) : print 되는 기능을 정의 
* OrderWoker (class) : AbstractOrder 을 상속을 받아서 기능을 재정의 해주었다, input 된 값이 o 또는 order 라면 작동되는 클래스 
  
