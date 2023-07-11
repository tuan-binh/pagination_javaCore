import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int limit = 5;
	static int page = 1;
	static int count;
	static int myPage;
	
	public static void main(String[] args) {
		count = 0;
		myPage = limit;
		List<String> list = new ArrayList<>();
		add(list);
		System.out.println(list);
		int pages = (int) Math.ceil((list.size() / limit));
		while (true) {
			
			print(list, count, myPage);
			System.out.printf("\n <<( 1 (<< | %d/%d | >>) 2 )>> \n", page, pages);
			System.out.print("Vui lòng chọn: ");
			int choice = ConfigScanner.configScanner().nextInt();
			switch (choice) {
				case 1:
					if (page != 1) {
						page -= 1;
						count -= limit;
						myPage -= limit;
					}
					break;
				case 2:
					if (page != pages) {
						count += limit;
						myPage += limit;
						page += 1;
					}
					break;
				default:
					return;
			}
		}
		
		
	}
	
	public static void add(List<String> list) {
		for (int i = 0; i < 18; i++) {
			list.add("Content " + (i + 1));
		}
	}
	
	public static void print(List<String> list, int count, int myPage) {
		for (int i = count; i < myPage; i++) {
			System.out.println(list.get(i));
		}
	}
}