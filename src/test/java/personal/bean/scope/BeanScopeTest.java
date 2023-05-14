package personal.bean.scope;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link BeanScope}のJUnit
 * ２つの{@link BeanScope}を注入し、{@link jakarta.inject.Singleton}と
 * {@link io.micronaut.context.annotation.Prototype}の動作の違いを確認する。
 */
@MicronautTest
public class BeanScopeTest {

    /**
     * {@link Inject}でもDI可能。
     */
    @Inject
    SingletonBean singleton1;

    @Inject
    SingletonBean singleton2;

    @Inject
    PrototypeBean prototype1;

    @Inject
    PrototypeBean prototype2;
    @Test
    void scopeTest() {

        // @SingletonをつけたBeanを検証
        // @Singletonはアプリケーション上に一つだけ作成される。
        // @Singletonは注入されても同じBeanを使いまわすので、getValueの値が同じになる
        var singletonBeanValue1 = singleton1.getValue();
        var singletonBeanValue2 = singleton2.getValue();

        // singletonBeanValue1とsingletonBeanValue2は同じ値か？
        System.out.println("---------!TEST!---------\nsingleton1:%s,singleton2:%s".formatted(singletonBeanValue1,singletonBeanValue2));
        Assertions.assertThat(singletonBeanValue1).isEqualTo(singletonBeanValue2);

        // @ProtoTypeをつけたBeanを検証
        // @ProtoTypeは注入されるごとに新しく作成されるので、getValueの値が変わる
        var prototypeBeanValue1 = prototype1.getValue();
        var prototypeBeanValue2 = prototype2.getValue();

        // prototypeBeanValue1とprototypeBeanValue2は違う値か？
        System.out.println("---------!TEST!---------\nprototype1:%s,prototype2:%s".formatted(prototypeBeanValue1,prototypeBeanValue2));
        Assertions.assertThat(prototypeBeanValue1).isNotEqualTo(prototypeBeanValue2);
    }
}


