

## 객체 설계 

<img width="745" alt="Screen Shot 2022-05-15 at 3 23 03 PM" src="https://user-images.githubusercontent.com/53357210/168460084-af6a4f90-6115-4d2a-bd0b-010d50bd0e58.png">


* Data (interface) : 콤마, 큰따움표 별로 데이터가 정의되어 있어서 created 메소드르 통해서 데이터를 만드는 기능 정의 
* DoubleQuotationData, CommaData (class) : 콤마, 큰따움표 별 각각의 클래스 정의 Data interface 에서 정의된 created 메소드를 각각 오버라이드 해서 각각 정의
* Load (intreface) : 데이터를 가지고 오는 기능을 정의 (ex) csv, json, 코드 데이터를 정의 하기 위해서 사용)
* DataLoader (class) : 코드 데이터를 가지고 오는 로더 / load interface 를 상속 
* input (interface) : ㅅ
