
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> iList=Arrays.asList(3,66,26,77,3);
		List<String>  sList=Arrays.asList("Puri","asd","asder");
		print(iList);
		print(sList);
		
		List<Integer> idList=new ArrayList<>();
		List<String> sdList=new ArrayList<>();
		copy(idList,iList);
		copy(sdList,sList);

	}

	private static <T> void copy(List<T> idList, List<T> iList) {
		// TODO Auto-generated method stub
		for (T t : iList) {
			idList.add(t);
		}
		for (T t : idList) {
			System.out.println(t);
		}
		
	}

	//if we put object we can't access as no covariance is supported
	//if we place ? it comes as unidentified,
	//hence items can only be fetched ,no changes like add can be done to list
	private static void print(List<?> iList) {
		// TODO Auto-generated method stub
		for (Object object : iList) {
			System.out.println(object);
		}
		
	}

}
