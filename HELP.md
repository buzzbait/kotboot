# application 패키지

### port.in
Hexagonal Architecture에서 UseCase를 단일 함수로 구현하는 접근방식은 UseCase를 더욱 단순하고 집중적으로 만들어 단일 책임 원칙(SRP)을 철저히 따르게 합니다:
일반적으로 전통적인 RDBMS 를 처리하는 로직에서는 테이블 기준으로 CRUD 가 발생되는데 이를 모두 One Method 로 구성하면 Interface 가 수도 없이
생성되는 상황이 발생.
테이블 기준의 작업 CRUD 는 하나의 UseCase 에서 구현한다


* <span style="color:orange">**단일 진입점**: UseCase 클래스는 오직 하나의 public 메서드만 가집니다.</span>
* <span style="color:orange">**명확한 목적**: 각 UseCase는 하나의 특정 작업만을 수행합니다.</span>
* <span style="color:orange">**간결성**: 복잡한 내부 구조 대신 단순하고 명확한 인터페이스를 제공합니다.</span>
```
interface DeleteBoardUseCase {
    fun deleteBoard(): Boolean
}
```
### port.out
Outgoing port는 애플리케이션이 외부 시스템과 통신하기 위해 의존하는 인터페이스입니다. 
이는 애플리케이션의 외부 의존성을 추상화하는 역할을 합니다:

* <span style="color:orange">**단일 책임**: 각 outgoing port는 하나의 명확한 목적만을 가져야 합니다.</span>
* <span style="color:orange">**관심사 분리**: 서로 다른 외부 시스템과의 통신은 별도의 outgoing port로 분리합니다.</span>
* <span style="color:orange">**응집도 높임**: 관련된 기능들만 하나의 outgoing port에 모읍니다.</span>
```
// 사용자 정보 관련 outgoing port
interface UserRepository {
    fun getUser(id: String): User
    fun saveUser(user: User)
}

// 결제 처리 관련 outgoing port
interface PaymentGateway {
    fun processPayment(amount: Double): Boolean
}

// 이메일 발송 관련 outgoing port
interface EmailService {
    fun sendEmail(to: String, subject: String, body: String)
}
```
# infrastructure 패키지

Infrastructure Layer 는 UI, Database, web APIs, Frameworks 등이 존재하는 영역입니다.
JPA,Mybatis 관련 클래스(인터페이스)를  해당 패키지 안에서 분리하여 scanPackages 작업을 효율적으로 적용
JPA,Mybatis 관련 클래스(인터페이스) 가 특정 도메인 패키지에 분리되어 있으면 해당 테이블의 책임소재 판단이
어렵고 scanPackages 시 중복될 위험도 포함되어 업무 도메인 안에 두지 않고 별도로 분리

### infrastructure.dbms
오라클,mysql 등 일반적인 dbms 설정 패키지 
* 멀티 데이터베이스 설정을 위해 infrastructure.dbms.master, infrastructure.dbms.submaster 로 구분
* 영속성을 mybaits,jpa 중 하나로 사용하거나 병행 사용하는 경우를 위해 패키지 분리

### infrastructure.message
kafka,rabbitMq 같은 메시지 서버 처리 패키지

### infrastructure.nosql
mongodb,casandra 같은 nosql 서버 처리 패키지