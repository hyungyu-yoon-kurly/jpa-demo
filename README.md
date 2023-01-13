|환경|버전|
|---|---|
|spring boot| 2.7.7|
|java|11|
|h2 db|http://localhost:8080/h2-console|


# JPA N+1 문제 살펴보기

### JPA의 쿼리 방법
- JPA에서는 JPQL(Java Persistence Query Language) 을 사용하여 엔티티 객체를 조회한다.
- 테이블 대상 쿼리가 아닌 엔티티 객체를 대상으로 쿼리

#### JPQL 특징
- 테이블이 아닌 객체를 검색하는 객체지향 쿼리
- SQL을 추상화 했기 때문에 특정 벤더에 종속적이지 않음
- JPA는 JPQL을 분석하여 SQL을 생성한 후 DB에서 조회

ex)
```java
List<Member> mebers =  em.createQuery("select m from Member m", Member.class)
        .getResultList();
```
## JPA의 연관관계 fetch 전략
### Eager
- id로 조회시 연관 관계로 이루어진 엔티티를 즉시 조인하여 가져옴

### Lazy
- 연관 관계로 이루어진 엔티티를 바로 가져오지 않고 프록시 객체만 가지고 있음
- 해당 연관관계 엔티티를 사용할 때 조회해서 가져옴

---

- @OneToOne : 1:1 관계 default Eager
- @OneToMany : 1:N 관계 default Lazy
- @ManyToOne : N:1 관계 default Eager
- @ManyToMany : 잘 사용하지 않음

## N+1 원인 
- JpaRepository는 내부적으로 JPQL로 쿼리를 생성한다.
- findAll() 로 조회시

### eager
- 그 즉시 연관관계인 엔티티들을 각각 돌아가면서 조회를 한다.

### lazy
- n+1은 eager, lazy의 차이에서 발생하는 것은 아니며 lazy쪽에서도 사용 로직이 있으면 발생할 수 있다.
- Lazy 전략이라면 프록시 객체를 갖고 있고, 실제 사용 시에 연관된 객체를 사용하면 n번의 조회 쿼리를 날린다.

## 해결방법
### join fetch 사용
- 조인을 직접적으로 명시해서 한번의 쿼리로 조회할 수 있도록 함

### batch size 정의
- batchSize를 사용하면 연관된 엔티티를 조회할 때 지정한 size 만큼 sql의 in 절을 사용해서 조회
- 최대 1000을 넘지 않는 것을 추천
- @BatchSize(size = 1000)
- ```spring.jpa.properties.hibernate.default_batch_fetch_size=1000```

### 하이버네이트 @Fetch(FetchMode.SUBSELECT)
- 연관된 데이터 조회시 서브 쿼리를 사용하여 n+1 문제 해결

## 정리
- 즉시로딩은 사용하지 말고 지연 로딩만 사용하는 것을 추천
- 즉시 로딩은 n+1은 물론 필요하지 않은 엔티티를 로딩해야하는 경우가 자주 발생함
- 성능 최적화 어려움
- 예상치 못한 쿼리가 발생할 가능성
- fetch join을 사용!