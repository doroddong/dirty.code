package ac.kr.ajou.longmethod;

import org.junit.Test;

public class LongMethodTest {


    // 싹다 이상하다
    public static final String CORRET_SOCIAL_STRING = "abcdef";

    @Test(expected = RuntimeException.class)
    public void dosomeThing_소셜스트링이_6자리가아니면에러(){
        LongMethod longMethod = new LongMethod();
        longMethod.doSomething("11111111","ab","abab");
    }

    @Test(expected = RuntimeException.class)
    public void dosomeThing_소셜스트림에숫자가있으면에러() {
        LongMethod longMethod = new LongMethod();
        longMethod.doSomething(CORRET_SOCIAL_STRING,"ab","abab");
    }

    @Test(expected = RuntimeException.class)
    public void 이름이5자리보다많으면에러() {
        LongMethod longMethod = new LongMethod();
        longMethod.doSomething(CORRET_SOCIAL_STRING,"123456","abab1313");
    }

}
