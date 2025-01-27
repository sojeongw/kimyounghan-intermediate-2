# 제네릭

## 제네릭이 필요한 이유

```java
public class IntegerBox {
    private Integer value;

    public void set(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}

public class StringBox {
    private String value;

    public void set(String object) {
        this.value = object;
    }

    public String get() {
        return value;
    }
}
```

- 단순히 set, get 하는 로직인데 타입이 달라서 중복으로 만들어야 한다.

```java
public class ObjectBox {
    private Object value;

    public void set(Object object) {
        this.value = object;
    }

    public Object get() {
        return value;
    }
}
```

```java
public class BoxMain2 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get(); // Object -> Integer 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String str = (String) stringBox.get(); // Object -> String 캐스팅
        System.out.println("str = " + str);

        // 잘못된 타입의 인수 전달시
        integerBox.set("문자100");
        Integer result = (Integer) integerBox.get(); // String -> Integer 캐스팅 예외
        System.out.println("result = " + result);
    }
}
```

- 중복을 해결하기 위해 Object로 선언한다.
- 하지만 get() 할 때마다 직접 다운 캐스팅을 해줘야 하고 잘못 캐스팅 했을 때 예외가 발생한다.
- 원하는 타입을 정확하게 지정해서 받을 수 없다.
- 코드 재사용성은 높아졌으나 타입 안정성이 떨어진다.

## 제네릭 적용

```java
public class GenericBox<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

```java
public class BoxMain3 {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>(); // 생성 시점에 T의 타입 결정
        integerBox.set(10);
        // integerBox.set("문자100"); // Integer 타입만 허용, 컴파일 오류

        Integer integer = integerBox.get(); // Integer 타입 반환 (캐스팅 X)
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("hello"); // String 타입만 허용
        String str = stringBox.get(); // String 타입만 반환
        System.out.println("str = " + str);

        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);

        // 타입 추론: 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
```

- 생성 시점에 원하는 타입을 결정할 수 있다.

### 제네릭 타입

- 클래스, 인터페이스를 정의할 때 타입 매개변수를 사용하는 것
- `GenericBox<T>`를 제네릭 타입이라고 한다.

### 타입 매개변수

- 제네릭 타입이나 메서드에서 사용되는 변수. 실제 타입으로 대체된다.
- `T`를 타입 매개변수라고 한다.

### 타입 인자

- 제네릭 타입을 사용할 떄 제공되는 실제 타입
- `GenericBox<Integer>`의 `Integer`를 일컫는다.

### 명명 관례

- E
    - Element
- K
    - Key
- N
    - Number
- T
    - Type
- V
    - Value
- S,U,V etc.
    - 2nd, 3rd, 4th types

### 기타

```java
class Data<K, V> {
}
```

- 여러 타입 매개변수를 선언할 수 있다.
- 타입 인자로 기본형은 상요할 수 없다. 대신 래퍼 클래스를 사용한다.

### raw 타입

```java
GenericBox integerBox = new GenericBox();
```

- `< >`로 사용 시점에 타입을 지정하지 않는 것
    - Object로 사용된다.
- 낮은 자바 버전과 호환하기 위해 어쩔 수 없이 만들어졌다. 사용하지 않는 게 좋다.

## 타입 매개 변수 제한

```java
public class AnimalHospitalV3<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public T getBigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
```

- Animal과 그 자식 타입만 받을 수 있게 제한한다.
- Animal이 제공하는 메서드도 이용할 수 있다.

## 제네릭 메서드

```java
public class GenericMethod {
    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    public static <T> T genericMethod(T t) {
        System.out.println("generic print: " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(T t) {
        System.out.println("bound print: " + t);
        return t;
    }
}
```

- 메서드를 호출하는 시점에 타입을 정한다.
- 인스턴스 메서드와 static 메서드에 모두 사용 가능하다.

```java
class Box<T> { // 제네릭 타입
    T instanceMethod(T t) {
    } //가능

    static T staticMethod1(T t) {
    } //제네릭 타입의 T 사용 불가능
}
```

- 단, 제네릭 '타입'은 static 메서드에 사용할 수 없다.
- 제네릭 타입은 객체를 생성하는 시점에 타입이 정해지는데, static은 인스턴스가 아니라 클래스 단위이기 때문이다.

## 제네릭 타입과 제네릭 메서드 간의 우선 순위

```java
public class ComplexBox<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public <T> T printAndReturn(T t) {
        System.out.println("animal.className: " + animal.getClass().getName());
        System.out.println("t.className: " + t.getClass().getName());

        // t.getName(); // 호출 불가 메서드는 <T> 타입이다. <T extends Animal> 타입이 아니다.
        return t;
    }
}

public class MethodMain3 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);
        ComplexBox<Dog> hospital = new ComplexBox<>();
        hospital.set(dog);

        // 제네릭 메서드 사용
        Cat returnCat = hospital.printAndReturn(cat);
        System.out.println("returnCat = " + returnCat);
    }
}
```

```text
animal.className: generic.animal.Dog
t.className: generic.animal.Cat
returnCat = Animal{name='냐옹이', size=50}
```

- 제네릭 메서드가 우선권을 가진다.
    - 제네릭 타입과 무관하게 메서드로 들어온 타입이 찍힌 것을 볼 수 있다.

```java
public class ComplexBox<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public <Z> Z printAndReturn(Z z) {
        //...
    }
}
```

- 하지만 모호한 것은 좋지 않으므로 되도록 이렇게 다른 이름을 사용하자.

## 와일드 카드

```java
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

```java
public class WildcardEx {

    // Box<Dog>을 전달하면서 T = Dog이 된다.
    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    // 제네릭 메서드가 아님
    // Box<Dog>을 전달한다. ?는 모든 타입을 다 받을 수 있다.
    // `Box<Dog>` , `Box<Cat>` 처럼 타입 인자가 정해진 제네릭 타입을 전달 받아서 활용할 때 사용한다.
    // ? == <? extends Object>
    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
    }

    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
    }

    static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
        return t;
    }

    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }
}
```

- `?`로 와일드 카드를 정의하면 어떤 타입이든 받을 수 있다.
- 와일드 카드는 일반적인 메서드에 사용할 수 있고 단순히 매개변수로 제네릭 타입을 받을 수 있는 것 뿐이다.
    - 제네릭 메서드처럼 타입을 결정하거나 복잡하게 작동하지 않는다.
    - 단순히 일반 메서드에 제네릭 타입을 받을 수 있는 매개변수가 있는 것 뿐이다.
- 제네릭 타입이나 제네릭 메서드가 꼭 필요한 게 아니라면 더 단순한 와일드 카드 사용을 권장한다.

```java
static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
    T t = box.get();

    // Dog dog = WildcardEx.printAndReturnGeneric(dogBox)
    System.out.println("이름 = " + t.getName());
    return t;
}

static Animal printAndReturnWildcard(Box<? extends Animal> box) {
    Animal animal = box.get();

    // Animal animal = WildcardEx.printAndReturnWildcard(dogBox)
    // 와일드 카드는 정확한 타입을 반환할 수 없다.
    System.out.println("이름 = " + animal.getName());
    return animal;
}
```

- 제네릭 메서드는 전달한 타입을 명확하게 반환할 수 있으나 와일드 카드는 그렇지 않다.
- 와일드카드는 이미 만들어진 제네릭 타입을 받아 활용할 때 사용한다.
    - 메서드의 타입을 타입인자를 통해 변경할 수 없다.

### 상한, 하한 와일드 카드

```java
Box<? extends Animal> box ...
Box<? super Animal> box ...
```

- 상한은 해당 타입과 그 하위 타입만 가능하다.
- 하한은 해당 타입과 그 상위 타입만 가능하다.

## 타입 이레이저

- 제네릭은 자바 컴파일 단계에서만 사용되고 컴파일 이후에는 제네릭 정보가 삭제된다.
    - `.java`에는 제네릭이 존재하지만 `.class`에는 존재하지 않는다.
- Object나 상한 타입으로 변경된다.

```java
// 소스 코드
class EraserBox<T> {
    public boolean instanceCheck(Object param) {
        return param instanceof T; // 오류
    }

    public void create() {
        return new T(); // 오류
    }
}

// 런타임
class EraserBox {
    public boolean instanceCheck(Object param) {
        return param instanceof Object; // 오류
    }

    public void create() {
        return new Object(); // 오류
    }
}
```

- 런타임에 모두 Object가 되어버린다.
- `instanceof`가 모두 참이 되어버리므로 허용하지 않는다.
- `new Object`는 개발자의 의도와 달라지므로 역시 허용하지 않는다.