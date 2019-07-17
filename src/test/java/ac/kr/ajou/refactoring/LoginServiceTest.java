package ac.kr.ajou.refactoring;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void 유저아이디가_널이거나_비어있으면_false테스트() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login(null, "pwd");
        assertFalse(result);

        LoginService loginService1 = new LoginService();
        boolean result1 = loginService1.login("", "pwd");
        assertFalse(result1);
    }

    @Test
    public void 유저아이디가존재하지않으면False() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("test11111", "pwd");
        assertFalse(result);
    }

    @Test
    public void 유저아이디가괜찮지만패스워드가틀리면Fals() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("test1", "pwd");
        assertFalse(result);
    }

    @Test
    public void 유저_아이디와패스워드가모두맞으면_True() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("test1", "test1");
        assertTrue(result);
    }

    @Test
    public void getUserNameById_맞는ID가없으면_null() {
        LoginService loginService = new LoginService();
        String result = loginService.getUserNameById("없는ID");
        assertNull(result);
    }

    @Test
    public void getUserNameById_맞는ID가있으면_String(){
        LoginService loginService =new LoginService();
        String result = loginService.getUserNameById("test1");
        assertThat(result,is("testUserName1"));
    }
    @Test
    public void getage_테스트() {
        LoginService loginService =new LoginService();
        List<Player> result = loginService.getAge(15);
        //assertThat(result,is(any));
    }

}
