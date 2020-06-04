
<div align="center">

 ### tasdik
[![Travis CI w/ Logo](https://img.shields.io/travis/enesusta/tasdik/master.svg?logo=travis)](https://travis-ci.com/enesusta/tasdik) 
[![Issues](https://img.shields.io/github/issues-raw/enesusta/tasdik.svg?maxAge=25000)](https://github.com/enesusta/tasdik/issues) 
[![Maven Central](https://img.shields.io/maven-central/v/com.github.enesusta/tasdik?color=red&style=flat-square)](http://search.maven.org/artifact/com.github.enesusta/tasdik)
[![javadoc](https://javadoc.io/badge2/com.github.enesusta/tasdik/javadoc.svg)](https://javadoc.io/doc/com.github.enesusta/tasdik)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?colorB=blue)](https://github.com/enesusta/bean-validator/blob/master/LICENSE)

</div>


#### What is it?

Tasdik is bean `(JavaBean, POJO)` validation library that uses Java **reflection API**.



#### Quick Installation

If you are using **Maven** you can add the repository by adding the following XML to your project `pom.xml` file.


```xml
<dependency>
  <groupId>com.github.enesusta</groupId>
  <artifactId>tasdik</artifactId>
  <version>1.7.7</version>
</dependency>
```

#### How could you use it?

Tasdik has 10 annotation to validate bean which uses in general purposes.

Those are:
- @False
- @True
- @Max
- @Min
- @Negative
- @Positive
- @NonNull
- @Size
- @Regex
- @Email

Lets assume that we have a bean which **we want to validate.**

```java
import com.github.enesusta.tasdik.fals.False;
import com.github.enesusta.tasdik.max.Max;
import com.github.enesusta.tasdik.min.Min;
import com.github.enesusta.tasdik.negative.Negative;
import com.github.enesusta.tasdik.nonnull.NonNull;
import com.github.enesusta.tasdik.positive.Positive;
import com.github.enesusta.tasdik.regex.Regex;
import com.github.enesusta.tasdik.size.Size;
import com.github.enesusta.tasdik.tru.True;
import com.github.enesusta.tasdik.validator.DefaultValidator;
import com.github.enesusta.tasdik.validator.Validator;

public class Example {

    public static class Bean {

        @False
        private boolean mustBeFalse;

        @True
        private boolean mustBeTrue;

        @Max(value = 10)
        private int mustBeAMaximumOf10;

        @Min(value = 5)
        private int mustBeAMin5;

        @Negative
        private int mustBeNegative;

        @Positive
        private int mustBePositive;

        @NonNull
        private Object mustBeNonNull;

        @Size(min = 5, max = 10)
        private String numberOfCharactersMustBeBetween5and10;

        @Regex(pattern = "\\d+")
        private String mustBeDigit;

        @Email
        private String mustBeEmail;

        /**
         * setter/getter/constructor and other stuffs
         */
    }

    public static void main(String[] args) throws IllegalAccessException {

        Bean bean = new Bean();
        /**
         * setter / getter etc on your bean
         */

        Validator validator = DefaultValidator.getInstance();
        boolean isValid = validator.isValid(bean);
    }

}

```

#### How tasdik works?

Tasdik is based on two interface.
- Validator
- FieldValidator

##### Validator

There are 1 concrete class of Validator.

- DefaultValidator

```java
import java.lang.reflect.Field;

public interface FieldValidator {
    boolean isFieldValid(Field field) throws IllegalAccessException;
}
```

##### FieldValidator

**FieldValidator** interface is heart of the instrastructe of Tasdik. There are 10 concrete class of FieldValidator.


Those are:
- FalseFieldValidator
- TrueFieldValidator
- MaxFieldValidator
- MinFieldValidator
- NegativeFieldValidator
- PositiveFieldValidator
- NonNullFieldValidator
- SizeFieldValidator
- RegexFieldValidator
- EmailFieldValidator

As mentioned above `Validator` interface has one concrete class. In this manner **DefaultValidator** class uses a specific class which name is **FieldContext** that uses `Strategy pattern`.

##### Implementation of FieldContext

```java
public class FieldContext {

    private static FieldContext instance = null;
    private Map<Class<? extends Annotation>, FieldValidator> contextMap = new HashMap<>(9);

    private FieldContext(final Object o) {
        initialize(o);
    }

    private void initialize(final Object object) {
        contextMap.put(Email.class, new EmailFieldValidator(object));
        contextMap.put(Min.class, new MinFieldValidator(object));
        contextMap.put(Max.class, new MaxFieldValidator(object));
        contextMap.put(Negative.class, new NegativeFieldValidator(object));
        contextMap.put(Positive.class, new PositiveFieldValidator(object));
        contextMap.put(Regex.class, new RegexFieldValidator(object));
        contextMap.put(Size.class, new SizeFieldValidator(object));
        contextMap.put(True.class, new TrueFieldValidator(object));
        contextMap.put(False.class, new FalseFieldValidator(object));
    }

    public static FieldContext getInstance(final Object o) {
        if (instance == null)
            instance = new FieldContext(o);
        return instance;
    }

    public boolean isValid(final Field field) throws IllegalAccessException {
        boolean isValid = true;
        for (Annotation annotation : field.getAnnotations())
            if (!contextMap.get(annotation.annotationType()).isFieldValid(field))
                isValid = false;
        return isValid;
    }

}
```

#### Visualisation Of Implementation

<p align="center">
<img src="https://raw.githubusercontent.com/enesusta/assets-host-for-github-pages/assets/diagrams/mermaid/tasdik/tasdik.svg?sanitize=true" width="800">
</p>
