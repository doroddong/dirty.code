package ac.kr.ajou.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StreamApiTest {

    @Test
    public void filterString_제대로_필터된_스트링을_반환() {
        StreamApi streamApi = new StreamApi();
        List<String> testStringList = new ArrayList<>();
        testStringList.add("aaa");
        testStringList.add("bbb");
        testStringList.add("ccc");
        testStringList.add("ccc");
        testStringList.add("eee");
        testStringList.add("fff");

        List<String> result = streamApi.filterString(testStringList,"ccc");
        assertTrue(result.size()==2);
        assertEquals(result.get(0),"ccc");
        assertThat(result.get(1),is("ccc"));
    }
}
