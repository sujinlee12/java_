package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		
		Map<String,String>map = new HashMap<String,String>();
		/*put(k,v) : k와 V값을 이용해서 추가,K가 중복되면 V만 수정
		map.put("abc", "def");
		**/
		
		map.put("abc","def");
		String prev = map.put("abc", "xyz");
		System.out.println(map);
		System.out.println(prev);
		
		/* get(K) : k와 일치하는 v를 리턴
		 * 
		 */
		
		String str = map.get("abc");
		System.out.println(str);
		
		/* containsKey(k) : k와 일치하는 key가 있는지 알려줌*/
		
		System.out.println(map.containsKey("abc"));

		/*remove(k) : k와 일치하는 요소를 삭제 후 value를 리턴*/
		str = map.remove("abc");
		System.out.println(str);
		
		map.put("zxc", "123");
		map.put("hello", "hi");
		
		/*keySet() : 맵에 있는 key들을 모아 set에 저장하여 반환*/
		Set<String>keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
			
	}

}
