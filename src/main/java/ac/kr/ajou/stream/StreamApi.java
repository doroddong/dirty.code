package ac.kr.ajou.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

    public List<String> filterString(List<String> stringList, String filter) {
        return stringList.stream()                                         //stream으로 단위마다 하나씩 넘겨준다
                .filter(string -> string.equals(filter))           //이 조건문이 true일때만 밑으로 넘겨주고 , 틀리면 무시
            .collect(Collectors.toList());                      //밑으로 온 모든 녀석들을 List에 넣어서 반환
    }

    public List<String> filterByName(List<Person> personList, String filterName) {
        return personList.stream()
                .filter(person -> person.getName().equals(filterName))
                .map(person -> person.getAddress())
                .collect(Collectors.toList());
    }

    public int getAggregationAge(List<Person> personList, String filterName)
    {
        return personList.stream()
                .filter(person -> person.getName().equals(filterName))
                .mapToInt(person -> person.getAge())
                .sum();
    }

    // 이건(현재 방식) 간단하지만 아래 (옛날 방식)는 복잡하다

        /*
        List<String> resultList = new ArrayList<>();
        for(String string : stringList)
        {
            if(string.equals(filter)){
                resultList.add(string);
            }
        }
        return resultList;
    }
         */
}

