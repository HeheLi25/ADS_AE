
public class AssExTest {
	public static void main(String[] args) {
		String[] data = new String[] {"s","m","c","a"};
		AssessmentSLL<String> list1 = new AssessmentSLL<String>();
		for(String n: data) {
			list1.insert(n);
		}
		//list1.insertTail("tiger");
		//list1.insertTail("z");
		//list1.deleteAlternate();
		//list1.printFirstToLast();
//		String[] data2 = new String[] {"p","o","n","e","b","a"};
//		AssessmentSLL<String> list2 = new AssessmentSLL<String>();
//		for(String n: data2) {
//			list2.insert(n);
//		}
//		String[] data3 = new String[] {"q"};
//		AssessmentSLL<String> list3 = new AssessmentSLL<String>();
//		for(String n: data3) {
//			list3.insert(n);
//		}
//		AssessmentSLL<String> merge = list1.merge(list2, list3);
//		merge.printFirstToLast();
		
		
	}

}
